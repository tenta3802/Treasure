var List=[
    "나이키 ACG 스미스 서밋 카고 팬츠 블랙 - 아시아",
    "나이키 ACG 스톰핏 ADV 케스케이드 레인 풀 집 자켓 블랙 - 아시아",
    "나이키 NRG 솔로 스우시 우븐 트랙 자켓 블랙 - 아시아",
    "나이키 x 피스마이너스원 롱슬리브 티셔츠 블랙 (DR0098-010)",
    "나이키 x 피스마이너스원 롱슬리브 티셔츠 화이트 (DR0098-100)",
    "나이키 x 피스마이너스원 와이드 팬츠 블랙 (DR0096-010)",
    "나이키 x 피스마이너스원 퀀도1 블랙 앤 화이트",
    "나이키 덩크 로우 레트로 그레이 포그",
    "나이키 에어포스 1 '07 WB 플랙스",
    "나이키 에어포스 1 '07 로우 화이트",
    "뉴발란스 530 화이트",
    "디젤 1DR 미니백 플라크 블랙",
    "디젤 1DR 숄더백 인 나파 레더 블랙",
    "디젤 1DR 숄더백 인 나파 레더 화이트",
    "스톤 아일랜드 101WN 브러쉬드 코튼 캔버스 올드이펙트 오버셔츠 블랙 - 22FW",
    "스톤 아일랜드 40522 크링클랩스 나일론 가먼트 다이드 후드 자켓 블랙 - 23SS",
    "스톤 아일랜드 B0943 나일론 메탈 스위밍 트렁크 블랙 - 23SS",
    "스톤 아일랜드 B0943 나일론 메탈 스위밍 트렁크 스카이 블루 - 23SS",
    "스투시 ITP 플라워 티셔츠 화이트",
    "스투시 x 리바이스 엠보스드 501 진 인디고",
    "스투시 x 마틴 로즈 콜라주 피그먼트 다이드 티셔츠 블랙",
    "스투시 베이직 스투시 티셔츠 화이트 2023",
    "스투시 빅 스탁 워터 쇼츠 블랙",
    "스투시 스탁 워터 쇼츠 블랙",
    "스투시 월드투어 티셔츠 화이트 2023",
    "스투시 웨이브 다이 비치 쉘 자켓 블랙",
    "아더에러 x 자라 오버사이즈 블레이저 블랙",
    "아디다스 삼바 OG 블랙 화이트 검",
    "아디다스 삼바 비건 화이트 블랙",
    "아미 스몰 하트 로고 울 가디건 블랙/느와르",
    "아미 스몰 하트 로고 티셔츠 블랙",
    "아워레가시 익스텐디드 써드컷 슈퍼라이트 워시",
    "아이앱 스튜디오 티셔츠 화이트 네이비 - 22FW",
    "아크테릭스 베타 LT 자켓 블랙",
    "아크테릭스 베타 자켓 블랙"
];


$(document).ready(function () {
    // input필드에 자동완성 기능을 걸어준다
    $('#search').autocomplete({
        source: List,
        focus: function (event, ui) {
            return false;
        },
        select: function (event, ui) {},
        minLength: 1,
        delay: 100,
        autoFocus: true,
    });
});

