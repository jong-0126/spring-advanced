package org.example.expert.domain.comment.controller;

import org.example.expert.config.JwtUtil;
import org.example.expert.domain.comment.service.CommentAdminService;
import org.example.expert.domain.user.enums.UserRole;
import org.example.expert.domain.user.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//관리자 댓글 삭제
@SpringBootTest
@AutoConfigureMockMvc
class CommentAdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CommentAdminService commentAdminService;
    @Autowired
    private JwtUtil jwtUtil;

    @Test
    @DisplayName("관리자 댓글 삭제")
    void deleteComment() throws Exception{
        //given
        long commentId = 1L;
        doNothing().when(commentAdminService).deleteComment(commentId);

        String token = jwtUtil.createToken(1L, "admin@example.com", UserRole.ADMIN);

        //when & then
        mockMvc.perform(delete("/admin/comments/{commentId}", commentId)
                .header("Authorization", token))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("관리자 아님 - 댓글 삭제 실패")
    void deleteCommentWithoutAdmin() throws Exception {
        long commentId = 1L;
        String token = jwtUtil.createToken(2L, "user@example.com", UserRole.USER);

        mockMvc.perform(delete("/admin/comments/{commentId}", commentId)
                        .header("Authorization", token))
                .andExpect(status().isForbidden());
    }
}