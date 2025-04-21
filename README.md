# 🧑‍💻 Expert 프로젝트 - 과제 수행 정리

## 📌 프로젝트 개요

이 프로젝트는 Spring Boot 기반의 RESTful 웹 애플리케이션이며, 인증/인가, API 로깅, 테스트 코드, 성능 최적화 등 실무 중심의 기능 구현 및 리팩토링을 목표로 합니다.

---

## 📂 목차

1. [필수 기능 구현](#-필수-기능)
2. [N+1 문제 해결](#-lv-2-n1-문제)
3. [테스트 코드 개선](#-lv-3-테스트코드-연습)
4. [API 로깅 (Interceptor & AOP)](#-lv-4-api-로깅-선택)
5. [테스트 커버리지 첨부](#-lv-6-테스트-커버리지-선택)

---

## Lv 1. 필수 기능

### ✅ 1. `signup()` - Early Return 적용

### ✅ 2. `getTodayWeather()` - if-else 제거

### ✅ 3. `changePassword()` - DTO 기반 Validation

---

## 🧠 Lv 2. N+1 문제

- 기존 JPQL에서 `fetch join`을 사용해 N+1 문제를 해결하고 있었습니다.
- 이를 `@EntityGraph(attributePaths = {"user"})`로 변경하여 더 명시적이고 선언적으로 최적화하였습니다.

---

## ✅ Lv 3. 테스트코드 연습

- 테스트 시나리오 1~3번 모두 수정하여 성공하도록 처리

---

## 📊 Lv 4. API 로깅

- 관리자 전용 API (`deleteComment()`, `changeUserRole()`)에 대해 Interceptor를 통해 접근 로그를 수집합니다.

### ✅ Interceptor
- `HttpServletRequest`에서 `/admin/**` 요청인지 확인하고 관리자 여부 검증 후 로그 출력

---


## 📈 Lv 5. 테스트 커버리지

### ✅ IntelliJ Run with Coverage 사용 결과
  
![image](https://github.com/user-attachments/assets/2cfb8596-eadf-4a35-bcf5-856a3048a2b8)

---
