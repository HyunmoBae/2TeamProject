### README.md

# 상권 정보제공 사이트

> **상크스 (상권정보 크고 스마트하게)**  
> 지도 API와 상권 정보를 활용해 창업에 필요한 정보를 제공하여 폐업률을 낮추기 위한 서비스

---

## 프로젝트 추진 배경

사전 지식이 부족한 창업자들을 위해 지도 API를 활용한 상권 정보 제공 서비스를 개발 진행
이를 통해 창업 위치 선정의 어려움을 해결하고 폐업률을 낮추는 데 기여하고자 함

---

## 프로젝트 개요

- **프로젝트 기간**: 2023.04.25 ~ 2023.05.30 (5주)  
- **팀명**: 상크스 (상권정보 크고 스마트하게)  
- **운영 환경**:  
  - **DB**: MySQL  
  - **언어**: Java 11  
  - **백엔드**: Spring Boot  
  - **프론트엔드**: HTML, CSS, JavaScript  
  - **클라이언트 환경**: 웹  
- **지도 API**: 카카오 지도 API  
- **데이터 소스**: Localdata  

---

## 기술 스택

| ![Frontend](https://github.com/user-attachments/assets/2f5059c3-8c3b-46c7-8958-67708c80060e) | ![Backend](https://github.com/user-attachments/assets/e0df9878-8d90-4a87-ade7-2ab8abff7e7a) | ![IDE 및 협업관리 도구](https://github.com/user-attachments/assets/557f015b-303d-4154-af34-487e4554a4e0) |
|:--:|:--:|:--:|
| **Frontend** | **Backend** | **IDE 및 협업관리 도구** |

---

## 팀 구성 및 역할

| 이름     | 역할                  | 담당 업무                               |
|----------|-----------------------|-----------------------------------------|
| 박동진   | 팀장 / Backend         | 백엔드 설계 및 개발                     |
| 하성재   | 팀원 / Backend         | 백엔드 설계 및 개발                     |
| 손진영   | 팀원 / Frontend & Backend | 프론트엔드 및 백엔드 설계 및 개발        |
| 배현모   | 팀원 / Frontend & Backend | 프론트엔드 및 백엔드 설계 및 개발        |
| 김리나   | 팀원 / Frontend         | 프론트엔드 설계 및 개발                 |

---

## 주요 기능

1. **지도 API를 활용한 상권 분석**  
   - 근처 영업 중인 가게의 위치 확인 및 카테고리 분류  
   - 영업/폐업 상태에 따른 카테고리 분류로 특정 상권 파악 가능  

2. **게시판 기능**  
   - 창업자 간의 상권 정보 공유 및 리뷰 작성  
   - 주변 상권에 대한 고충 및 창업 관련 정보를 손쉽게 확인 가능  
   - 신규 창업자들이 위치 선택 및 투자 규모 조정 등 창업 준비를 효율적으로 할 수 있도록 지원  

3. **영업/폐업 데이터 제공**  
   - 현재 영업/폐업 중인 가게 확인  
   - 카테고리를 통해 특정 업종의 정보를 습득 가능  

---

## 프로젝트 결과

- **상권 분석 지원**:  
  창업자들은 지도를 통해 근처 영업/폐업 중인 가게를 확인하고, 카테고리별 데이터를 활용하여 창업에 필요한 정보를 습득할 수 있음
- **정보 공유 활성화**:  
  게시판을 통해 누적된 데이터로 동종업계 경쟁 업체, 매출 정보, 특정 상권 정보 등을 확인하며 창업 실패율을 줄이고 상권 분석에 대한 이해도 향상

### 지도 화면
| 초기화면 | 영업 중인 가게 |
|:--:|:--:|
| ![초기화면](https://github.com/user-attachments/assets/76de9e36-676a-4612-91f5-d93fd74d5bb8) | ![영업 중인 가게](https://github.com/user-attachments/assets/b652135e-96e1-4d7c-a90e-38894aaaf4bf) |

| 폐업한 가게들 | 폐업한 가게 상세 |
|:--:|:--:|
| ![폐업한 가게들](https://github.com/user-attachments/assets/73cefce2-3ea2-4233-a35c-de03c02c3cf9) | ![폐업한 가게 상세](https://github.com/user-attachments/assets/2d3da72d-b448-4d39-868b-69dbf7b63b0c) | 

### 게시판 화면
| 전체 게시판 | 게시판 글 작성 |
|:--:|:--:|
| ![전체 게시판](https://github.com/user-attachments/assets/8197bb1b-11dd-4212-a4d2-1e3235cb04a6) | ![게시판 글 작성](https://github.com/user-attachments/assets/1259991e-633d-4172-87fe-0c26f68c2ef9) |

| 개인정보 변경 | 내 글 목록 |
|:--:|:--:|
| ![개인정보 변경](https://github.com/user-attachments/assets/0ce12933-ccab-4242-b078-c15e68ef2888) | ![내 글 목록](https://github.com/user-attachments/assets/1ae91e89-e9b1-476a-a524-3d58df39c5d3) |
---

## 개발 특이사항

- **카카오 지도 API 활용**: 상권 분석을 위한 지도 기반 데이터 시각화  
- **Localdata 활용**: 공공 데이터를 통한 영업/폐업 정보 수집 및 가공  

---

## 문제점 및 향후 개선 방향

1. **인구 밀집도 데이터 추가**  
   - 특정 지역의 유동 인구 및 연령대 분석 기능 추가 예정  

2. **매출액 데이터 추가**  
   - 카테고리별 대략적인 매출액을 제공하여 게시판을 통하지 않아도 매출 정보를 파악할 수 있도록 개선 예정  

---
