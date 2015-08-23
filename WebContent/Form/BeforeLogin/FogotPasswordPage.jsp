<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="botDetect" uri="botDetect"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="register stacked">
  <div class="row">
   <div class="row-same-height">
    <div class="col-sm-height col-middle">
     <div class="account-container content clearfix ">
      <form:form id="regiter_form" action="resetPassword.html" method="post">
       <div class="forgotpass-top-icon">
        <h1>
         <label style="color: #2e6da4;">Forgot Password</label>
        </h1>
        <br>
       </div>
       <div class="login-fields">
        <div class="send-has-error"></div>
        <!-- Loading Box -->
        <jsp:include page="/Form/Common/pagedialog.jsp"></jsp:include>
        <!-- /Loading Box -->
        <!-- /field -->
        <div class="field form-group">
         <form:label path="userEmail" for="email">Email Address:</form:label> <form:input path="userEmail" type="text"
          id="email" name="email" value=""
          placeholder="Email address"
          class="form-control" data-fv-emailaddress="true"
          data-fv-notempty="true"
          data-fv-notempty-message="Email is required." />
        </div>
        <!-- /field -->
        <!-- Adding BotDetect Captcha to the page-->
        <botDetect:captcha id="ajaxValidatedCaptcha" />
        <div class="validationDiv field form-group">
         <input type="text" id="captchaCodeTextBox"
          name="captchaCodeTextBox" value=""
          placeholder="Captcha"
          class="form-control" data-fv-notempty="true"
          data-fv-notempty-message="This field is required" />
         <!-- <input type="button" id="validateCaptchaButton" name="validateCaptchaButton" value="Validate"  onclick="check()"/> -->
        </div>

        <!-- /field -->
       </div>
       <div class="divForCaptcha" id="divForCaptcha"
        style="color: rgb(165, 55, 55); display: None;">
        Captcha not math
       </div>
       <!-- /login-fields -->
       <div class="form-group" align="center">
        <input type="submit" class="send-action btn btn-primary" value="Reset password"/>
       </div>
       <!-- .actions -->
      </form:form>
     </div>
    </div>
   </div>
  </div>
  <!-- /content -->
 </div>