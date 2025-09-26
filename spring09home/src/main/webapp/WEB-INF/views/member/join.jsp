<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
    .guage 
    {
        transition-property: width;
        transition-duration: 0.2s;
        transition-timing-function: ease-out;
    }
    .progressbar {
        width: 100%;
        height: 5px;
    }
    .progressbar > .guage {
        width: 0%;
        height: 100%;
        background: #465ee3;
        background: linear-gradient(90deg, rgba(70, 94, 227, 1) 0%, rgba(87, 199, 133, 1) 50%, rgba(237, 221, 83, 1) 100%);
    }
</style>
<!-- 카카오 우편 API CDN -->
<script src = "//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src = "/js/kakao.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type = "text/javascript">
    $(function(){
        var state = {
            memberIdValid : false,
            memberPwValid : false,                
            memberNicknameValid : false,
            memberEmailValid : false,
            memberBirthValid : true,
            memberContactValid : true,
            ok : function(){
                return this.memberIdValid && 
                this.memberPwValid &&
                this.memberNicknameValid &&
                this.memberEmailValid &&
                this.memberBirthValid &&
                this.memberContactValid;
            }
        };

        $("[name=memberId]").on("blur", function(){
            var regex = /^[a-z][a-z0-9]{4,19}$/;
            var valid = regex.test($(this).val());
            $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
            state.memberIdValid = valid;
        });

        $("[name=memberPw]").on("blur", function(){
            var regex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])+$/;
            var valid = regex.test($(this).val());
            $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
            state.memberPwValid = valid;
        });

        $("[name=memberNickname]").on("blur", function(){
            var regex = /^[가-힣0-9]{2,10}$/;
            var valid = regex.test($(this).val());
            $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
            state.memberNicknameValid = valid;
        });

        $("[name=memberEmail]").on("blur", function(){
            var regex = /[A-Za-z0-9_-]+@[A-Za-z0-9_-]+/;
            var valid = regex.test($(this).val());
            $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
            state.memberEmailValid = valid;
        });

        $("[name=memberBirth]").on("blur", function(){
            var regex = /^(19[0-9]{2}|20[0-9]{2})-((02-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$/;
            var valid = regex.test($(this).val());
            $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
            state.memberBirthValid = valid;
        });

        $("[name=memberContact]").on("blur", function(){
            var regex = /^010[1-9][0-9]{7}$/;
            var valid = regex.test($(this).val());
            $(this).removeClass("success fail").addClass(valid ? "success" : "fail");
            state.memberContactValid = valid;
        });

        $(".check-form").on("submit", function(){
            $(this).find("[name]").trigger("blur");
            return state.ok();
        });

        var page = 0;
        var totalPage = $(".page").length - 1;

        $(".page").hide();
        $(".page").first().show();//$(".page").eq(page).show();

        updatePage();
        updateProgress();

        $(".btn-next").on("click", function () {
            $(this).closest(".page").hide();//$(".page").eq(page).hide();
            page++;
            $(this).closest(".page").next().show();////$(".page").eq(page).show();
            updatePage();
            updateProgress();
        });

        $(".btn-prev").on("click", function () {
            $(this).closest(".page").hide();//$(".page").eq(page).hide();
            page--;
            $(this).closest(".page").prev().show();//$(".page").eq(page).show();
            updatePage();
            updateProgress();
        });

        function updateProgress()
        {
            var percent = (page / totalPage) * 100 + "%";
            $(".guage").css("width", percent);
        }

        function updatePage()
        {
            $(".total-page").text(totalPage + 1);
            $(".current-page").text(page + 1);
        }
    });
</script>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form autocomplete="off" action="join" method="post"
     enctype="multipart/form-data" class = "check-form">
        <div class="container w-600">
            <div class="cell center">
                <h1>회원 가입 정보 입력</h1>
            </div>

            <div class="cell center">
                <span class="current-page"></span>
                /
                <span class="total-page"></span>
            </div>
            <div class="cell">
                <div class="progressbar">
                    <div class="guage"></div>
                </div>
            </div>

            <div class="cell page">
                <label>아이디 <span class="red">*</span></label>
                <input type="text" name="memberId" placeholder="영문 소문자로 시작하며 숫자 포함 5~20자" 
                            class="field w-100">
                <div class="fail-feedback">아이디의 첫 글자는 소문자로 시작하여 숫자가 포함되며 5~20글자입니다.</div>
                <div class="cell mt-30 flex-box flex-center">
                    <button type="button" class="btn btn-positive btn-next">다음 <i class="fa-solid fa-arrow-right"></i></button>
                </div>
            </div>
            <div class="cell page">
                <label>비밀번호 <span class="red">*</span></label>
                <input type="password" name="memberPw" placeholder="대소문자, 숫자, 특수문자를 반드시 포함한 8~16자" 
                            class="field w-100">
                <div class="success-feedback"></div>
                <div class="fail-feedback"></div>
                <div class="cell mt-30 flex-box flex-center">
                    <button type="button" class="btn btn-positive btn-prev me-10"><i class="fa-solid fa-arrow-left"></i>이전</button>
                    <button type="button" class="btn btn-positive btn-next ms-10">다음 <i class="fa-solid fa-arrow-right"></i></button>
                </div>
            </div>
            <div class="cell page">
                <label>닉네임 <span class="red">*</span></label>
                <input type="text" name="memberNickname" placeholder="한글 또는 숫자 2~10자" 
                    class="field w-100">
                <div class="success-feedback">옳은 닉네임입니다.</div>
                <div class="fail-feedback">숫자가 포함된 한글이어야 하며 2~10글자입니다.</div>
                <div class="cell mt-30 flex-box flex-center">
                    <button type="button" class="btn btn-positive btn-prev me-10"><i class="fa-solid fa-arrow-left"></i>이전</button>
                    <button type="button" class="btn btn-positive btn-next ms-10">다음 <i class="fa-solid fa-arrow-right"></i></button>
                </div>
            </div>
            <div class="cell page">
                <label>이메일 <span class="red">*</span></label>
                <input type="email" inputmode="email" name="memberEmail" placeholder="test@kh.com"
                    class="field w-100">
                <div class="fail-feedback">이메일이 틀렸습니다.</div>
                <div class="cell mt-30 flex-box flex-center">
                    <button type="button" class="btn btn-positive btn-prev me-10"><i class="fa-solid fa-arrow-left"></i>이전</button>
                    <button type="button" class="btn btn-positive btn-next ms-10">다음 <i class="fa-solid fa-arrow-right"></i></button>
                </div>
            </div>
            <div class="cell page">
                <label>생년월일</label>
                <input type="date" name="memberBirth" class="field w-100">
                <div class="fail-feedback">생일이 형식과 다릅니다.</div>
                <div class="cell mt-30 flex-box flex-center">
                    <button type="button" class="btn btn-positive btn-prev me-10"><i class="fa-solid fa-arrow-left"></i>이전</button>
                    <button type="button" class="btn btn-positive btn-next ms-10">다음 <i class="fa-solid fa-arrow-right"></i></button>
                </div>
            </div>
            <div class="cell page">
                <label>연락처</label>
                <input type="tel" inputmode="tel" name="memberContact" class="field w-100"
                        placeholder="010XXXXXXXX (- 제외하고 작성)">
                <div class="fail-feedback">전화번호는 0101???????입니다.</div>
                <div class="cell mt-30 flex-box flex-center">
                    <button type="button" class="btn btn-positive btn-prev me-10"><i class="fa-solid fa-arrow-left"></i>이전</button>
                    <button type="button" class="btn btn-positive btn-next ms-10">다음 <i class="fa-solid fa-arrow-right"></i></button>
                </div>
            </div>
            <div class="cell page">
                <label style="display: block;">주소</label>
                <input type="text" name="memberPost" placeholder="우편번호" class="field"
                            size="6">
                <button type="button" class="btn btn-neutral btn-address-search">검색</button>
                <button type="button" class="btn btn-negative btn-address-clear" style="display: none;">
                    <i class="fa-solid fa-xmark"></i>
                </button>
                <div class="cell">
                    <input type="text" name="memberAddress1" placeholder="기본주소" class="field w-100">
                </div>
                <div class="cell">
                    <input type="text" name="memberAddress2" placeholder="상세주소" class="field w-100">
                    <div class="fail-feedback">우편번호, 기본주소, 상세주소를 모두 입력해주셔야 합니다.</div>
                </div>
                <div class="cell mt-30 flex-box flex-center">
                    <button type="button" class="btn btn-positive btn-prev me-10"><i class="fa-solid fa-arrow-left"></i>이전</button>
                    <button type="button" class="btn btn-positive btn-next ms-10">다음 <i class="fa-solid fa-arrow-right"></i></button>
                </div>
            </div>
            <div class="cell page">
                <label>프로필 이미지(선택)</label>
                <input type="file" name="attach" accept="image/*" class="field w-100">
                <div class="cell mt-30 flex-box flex-center">
                    <button type="button" class="btn btn-positive btn-prev me-10"><i class="fa-solid fa-arrow-left"></i>이전</button>
                    <button type="submit" class="btn btn-positive ms-10">회원가입</button>
                </div>
            </div>
        </div>
    </form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>