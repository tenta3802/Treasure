<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
          rel="stylesheet">
    <title>Treasure</title>
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="application/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
            charset="utf-8"></script>
    <style>
        @font-face {
            font-family: "GmarketSansMedium";
            src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff") format("woff");
            font-weight: normal;
            font-style: normal;
        }

        div.main {
            font-family: "GmarketSansMedium";
            font-size: 13px;
            padding: 0;
            margin: 0;
            border: none;
        }

        .search-wrapper {
            width: 480px;
            padding: 40px;
            box-sizing: border-box;
            margin-left: 33%;
            margin-top: 20px;
            line-height: 30px;
        }

        .login-wrapper > h2 {
            font-size: 24px;
            color: black;
            margin-bottom: 40px;
            text-align: center;
        }

        #search-form > input:not(.btn-search) {
            width: 100%;
            height: 48px;
            padding: 0 10px;
            box-sizing: border-box;
            margin-bottom: 16px;
            border-radius: 6px;
            background-color: #F8F8F8;
            font-family: "GmarketSansMedium";
        }

        #search-form > input::placeholder {
            color: #D2D2D2;
        }

        #search-form > input[type="checkbox"] {
            display: none;
        }

        #search-form > label {
            color: #babbbc;
        }

        #search-form input[type="checkbox"] + label {
            cursor: pointer;
            padding-left: 26px;
            background-repeat: no-repeat;
            background-size: contain;
        }

        #search-form input[type="checkbox"]:checked + label {
            background-repeat: no-repeat;
            background-size: contain;
        }

        .btn-search {
            font-size: 14px;
            color: #fff;
            background-color: #747f55;
            padding: 5px 20px;
            border-radius: 10px;
            font-weight: 400;
            text-transform: capitalize;
            letter-spacing: 0.5px;
            transition: all 0.3s;
            position: relative;
            overflow: hidden;
            margin-top: 20px;
            width: 100%;
            text-align: center;
        }

        .btn-search:hover {
            background-color: #fff;
            color: #747f55;
            border: 1px solid #747f55;
        }

        #logo i {
            font-size: 25px;
            margin-left: 30%;
            font-weight: bold;
            margin-bottom: 40px;
        }

        #logo {
            margin-bottom: 20px;
        }

        .hr {
            border: none;
            height: 2px;
            background: black;
            margin-bottom: 20px;
        }

        #note {
            opacity: 0.7;
            margin-bottom: 30px;
        }

        #content {
            font-size: 15px;
            margin: 100px 0;
            line-height: 30px;
        }
    </style>
    <script>
        $(document).ready(function () {
            $("#result-form").hide();
            $(".btn-search").click(function () {
                let email = $("#email").val();
                $.ajax({
                    type: "get",
                    url: "passSearchMailSender",
                    data: {"email":email},
                    success: function(res) {
                        $("#search-form").hide();
                        if (res===1) {
                            $("#content").innerHTML("입력하신 이메일로 임시 비밀번호를 전송하였습니다.");
                        } else {
                            $("#content").append("가입된 이메일이 존재하지 않습니다.");
                            $(".moveLogin").hide();
                        }
                        $("#result-form").show();
                    }
                });
            });
        });
    </script>
</head>
<body>
<div class="search-wrapper">
    <div id="logo"><i>비밀번호 찾기</i></div>
    <div class="hr"></div>
    <div id="note" align="center">가입 시 등록하신 이메일을 입력하시면,<br>이메일로 임시 비밀번호를 전송해 드립니다.</div>
    <form id="search-form">
        이메일
        <input type="text" name="email" id="email" required="required">

        <input type="button" value="임시 비밀번호 전송" class="btn-search submitBtn">
    </form>
    <form id="result-form">
        <div id="content" align="center"></div>
        <div class="hr"></div>
        <input type="button" value="로그인하러 가기" class="btn-search moveLogin"
               onclick="location.href='loginForm'">
    </form>
</div>
</body>
</html>
