# Treasure <a href="https://www.youtube.com/watch?v=DzTVOzSCGL0"><img src="https://img.shields.io/badge/youtube-FF0000?style=flat&logo=youtube&logoColor=white"/></a>


'프로젝트 트레저(Treasure)'는 젊은 층을 주요 타겟으로 한 '한정판 제품'에 대한 관심과 수요가 높은 현상을 바탕으로, 리셀(Resell) 시장을 대상으로한 거래 중개 사이트를 구축하는 프로젝트입니다.
사용자가 저희 사이트에서 보물같은 상품을 발견하고, 그 여정이 즐겁기를 바라며 treasure라고 이름을 지었습니다.
<br><br>


## 사용 기술
<img width="550" alt="사용 기술들ㅇ" src="https://github.com/treasure-final/Treasure/assets/84509774/9fd796bb-246e-46a0-894d-a0ed2b0e7f29">
<br><br>

## 구현 기능

### ✅ User
- 회원가입
  - 이메일, 비밀번호 유효성 검사
  - 도로명 주소 API를 통한 주소지 입력
  - 모달창을 이용한 동의 필수 항목 내용 출력
- 로그인 / 로그아웃
  - Session을 통한 로그인 상태 유지 및 아이디 저장 기능
  - 네이버, 카카오 API를 통한 로그인(카카오 로그인 시 추가 정보 입력)
- 이메일 찾기
  - 회원 정보(이름, 생년월일, 전화번호) 입력을 통한 이메일 찾기 기능
  - 회원 정보가 모두 일치할 경우 가입된 이메일 부분 출력
  - 회원 정보가 일치하지 않을 경우 불일치 출력문 출력
- 비밀번호 찾기
  - 사용자 이메일을 통한 비밀번호 찾기 기능
  -  메일 API를 통해 이메일이 존재할 경우 이메일로 임시 비밀번호 전송
- 회원 정보 수정
  - 마이페이지의 회원정보 및 프로필 수정 가능
- 상품 관리
  - 구매 입찰 등록, 즉시 구매한 상품의 정보 조회 가능
  - 판매 상태(판매완료, 판매불가, 판매대기)에 따른 전체 판매 내역 조회 가능
  - 구매 및 판매 상품 상세 조회 가능
<br><br>
<hr>
<br>

### ✅ Item
- 상품 검색 및 조회
  - 메인페이지 상단 검색창을 통해 초성만 입력해도 상품명 자동 완성
  - 브랜드, 카테고리별 필터 적용을 통한 상품 조회 가능
- 상품 상세 조회
  - 브랜드, 상품명 등 상품 정보, 사이즈별 최근 거래가, 기간별 & 거래 분류별 시세 배송 정보, 구매 전 안내 사항 표시
  - 상품 상세보기 창 내부 스크롤 가능
  - 상품 상세보기 창 하단 같은 브랜드와 카테고리의 상품 리스트 조회 가능
  - 가장 최근 체결된 거래 내역 2개를 조회하여 가격 변동률 및 가격 변동량 계산 후 출력
  - 사이즈 변경 시 최근 거래가, 시세 차트, 체결 거래, 판매 입찰, 구매 입찰 내역 변경(최대 5개까지 조회 가능)
  - Chart js를 활용한 시세 차트 출력
- 상품 구매
  - 상품 카테고리에 따라 사이즈 다르게 출력
  - 판매 입찰이 가능한 상품이 있다면 사이즈와 가격 표시
  - 판매 입찰이 가능한 상품이 없다면 구매입찰로 표시
  - 구매 입찰 상품 구매 시 구매 희망가 범위 설정(5만원부터 천 단위 입력 가능)
  - 구매 희망가 입력 후 엔터 또는 화면 클릭 시 화폐 단위로 전환
  - 입찰 마감 기한 선택 가능
  - 모든 데이터 입력 시 버튼 활성화
  - 즉시 구매가보다 구매 희망가가 더 높을 경우 자동으로 즉시 구매 페이지로 이동
  - 토스 페이 또는 카카오페이를 통한 상품 주문 및 결제 가능
- 상품 판매
  - 판매 희망가 입력 후 엔터 또는 화면 클릭 시 화폐 단위로 전환, 동시에 수수료(판매 희망가격의 20%)와 검수비를 제외하여 계산한 총 정산금액 표시
  - 판매 희망가 가격 범위 설정(4천원부터 천 단위로 입력 가능)
  - 검수 불합격 상품의 경우 판매 불가, 검수 합격 시 판매 대기 상태
  - 판매 대기인 상품이 구매 완료가 되었을 경우 구매 상품 상태 구매 완료로 변경
<br><br>
<hr>
<br>

 ### ✅ Style
 - 게시글 등록
    - 상품과 관련된 스타일 게시글(이미지, 제목, 내용)등록 가능
 - 총 게시글 조회
    - 내 스타일 버튼 클릭 시 사용자가 등록한 게시글 정보 조회 가능
 - 게시글 삭제
    - 게시글 개별 삭제 및 전체 삭제 가능
 - 게시글 추천
    - 로그인한 유저는 좋아요 버튼을 통해 상품 추천 및 추천 취소가 가능
 - 게시글 상세 조회
    - 각 게시글의 상세 정보(작성자 프로필 사진, 닉네임, 작성 날짜, 게시글 정보) 조회 가능
<br><br>
<hr>
<br>

### ✅ ETC
- 카카오 챗봇을 통한 Q&A 기능
  - 구매, 판매, 겁수 기준 등 자주 묻는 질문을 정리하여 사용자가 단어 입력시 관련된 답변을 자동으로 반환
<br><br>
<hr>
<br>

## ERD
![erdcloudreal](https://github.com/treasure-final/Treasure/assets/84509774/22b66ab6-ec7d-4613-9d3a-df088a6432a2)
<br><br>

## 테이블 정의서
<img width="800" alt="image" src="https://github.com/treasure-final/Treasure/assets/84509774/1bd27811-ff26-4b0f-9688-a4fc0f1fefe1">
<img width="800" alt="image" src="https://github.com/treasure-final/Treasure/assets/84509774/29c5c03b-a80c-4aa8-a3cc-a07e9bec55a5">

<br><br>
