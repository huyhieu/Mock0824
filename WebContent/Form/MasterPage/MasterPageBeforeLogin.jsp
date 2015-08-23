<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link id="siteIcon" rel="shortcut icon" type="image/gif" href="./PAGE-STYLE/images/ic_logo.png">
<title>Register Account</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<link href="./PAGE-STYLE/bootstrap/css/pages/signup.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="./PAGE-STYLE/bootstrap/js/dist/css/formValidation.css">
<link rel="stylesheet" href="./PAGE-STYLE/bootstrap/js/dist/css/datepicker.css">
<link href="./PAGE-STYLE/bootstrap/css/pages/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<!-- header -->
 <nav class="navbar navbar-inverse" role="navigation">
  <div class="container">
   <!-- Brand and toggle get grouped for better mobile display -->
   <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
     <span class="sr-only">Toggle navigation</span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
     <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="./">
     <div class="ic_viettel"></div>
     <div class="space"></div>
     <!-- <div id="vtapp">Viettel App Store</div> -->
     <p class="vtapp">Vmock</p>
    </a>
    <div class="lang" style="float: left; margin-left: 15px; margin-top: -10px;"></div>
   </div>
   <!-- Collect the nav links, forms, and other content for toggling -->
   <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav navbar-right">
     <li class="">
      <a href="./"> Sign In </a>
     </li>
    </ul>
   </div>
   <!-- /.navbar-collapse -->
  </div>
  <!-- /.container -->
 </nav>
<!-- /header --> 
 
 <div class="register stacked">
  <div class="row">
   <div class="row-same-height">
    <div class="col-sm-6 col-xs-6 col-md-6 col-lg-6 col-xlg-6">
     <div class="account-container content clearfix ">
      <form id="regiter_form" action="" method="post" novalidate="novalidate" class="fv-form fv-form-bootstrap">
       <button type="submit" class="fv-hidden-submit" style="display: none; width: 0px; height: 0px;"></button>
       <div class="login-fields">
        <div class="regist-has-error"></div>
        <!-- Loading Box -->
        <div class="modal fade" id="procesingModal" tabindex="-1" role="dialog" aria-labelledby="procesingModal" aria-hidden="true">
         <div class="modal-dialog processing" style="width: 90%;">
          <div class="modal-content">
           <div class="modal-body">
            <img style="width: 70px; height: 70px" src="./PAGE-STYLE/bootstrap/img/spin.gif">
           </div>
          </div>
         </div>
        </div>
        <div class="modal fade" id="pageModal" tabindex="-1" role="dialog" aria-labelledby="pageModal" aria-hidden="true">
         <div class="modal-dialog">
          <div class="modal-content">
           <div class="terms-close-button">
            <img id="closeButton" src="./PAGE-STYLE/bootstrap/img/common/close_button.png">
           </div>
           <div class="modal-body"></div>
          </div>
         </div>
        </div>
        <!-- /Loading Box -->
        <div class="field form-group">
         <label for="firstname"> Full Name : </label>
         <input type="text" id="fullname" name="fullname" value="" placeholder="Full Name" class="form-control" data-fv-stringlength="true" data-fv-stringlength-max="200"
          data-fv-notempty="true" data-fv-notempty-message="This field is required." data-fv-regexp="true"
          data-fv-regexp-regexp="[-a-zA-Z đĐAaĂăÂâEeÊêIiOoÔôƠơUuƯưYyÀàẰằẦầÈèỀềÌìÒòỒồỜờÙùỪừỲỳÁáẮắẤấÉéẾếÍíÓóỐốỚớÚúỨứÝýẢảẲẳẨẩẺẻỂểỈỉỎỏỔổỞởỦủỬửỶỷÃãẴẵẪẫẼẽỄễĨĩÕõỖỗỠỡŨũỮữỸỹẠạẶặẬậẸẹỆệỊịỌọỘộỢợỤụỰựỴỵ ]"
          data-fv-field="fullname"
         >
         <small class="help-block" data-fv-validator="notEmpty" data-fv-for="fullname" data-fv-result="NOT_VALIDATED" style="display: none;">This field
          is required.</small>
         <small class="help-block" data-fv-validator="regexp" data-fv-for="fullname" data-fv-result="NOT_VALIDATED" style="display: none;">Please enter
          a value matching the pattern</small>
         <small class="help-block" data-fv-validator="stringLength" data-fv-for="fullname" data-fv-result="NOT_VALIDATED" style="display: none;">Please
          enter a value with valid length</small>
        </div>
        <!-- /field -->
        <div class="field form-group">
         <label for="email"> Email : </label>
         <input type="text" id="email" name="email" value="" placeholder="Email" class="form-control" data-fv-emailaddress="true" data-fv-notempty="true"
          data-fv-notempty-message="This field is required." data-fv-field="email"
         >
         <small class="help-block" data-fv-validator="emailAddress" data-fv-for="email" data-fv-result="NOT_VALIDATED" style="display: none;">Please
          enter a valid email address</small>
         <small class="help-block" data-fv-validator="notEmpty" data-fv-for="email" data-fv-result="NOT_VALIDATED" style="display: none;">This field is
          required.</small>
        </div>
        <!-- /field -->
        <div class="field form-group">
         <label for="password"> Password : </label>
         <input type="password" id="password" name="password" value="" placeholder="Password" class="form-control" data-fv-notempty="true" data-fv-stringlength="true"
          data-fv-stringlength-max="30" pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[`~!@#$%^&amp;*()_|+\-=?;:',.<>\{\}\[\]\\\/]).{8,30})"
          data-fv-regexp-message="This field must contain at least 8 characters (at least one number, at least one uppercase character, at least one lowercase character  and one specical character)."
          data-fv-notempty-message="This field is required." data-fv-field="password"
         >
         <small class="help-block" data-fv-validator="notEmpty" data-fv-for="password" data-fv-result="NOT_VALIDATED" style="display: none;">This field
          is required.</small>
         <small class="help-block" data-fv-validator="regexp" data-fv-for="password" data-fv-result="NOT_VALIDATED" style="display: none;">This field
          must contain at least 8 characters (at least one number, at least one uppercase character, at least one lowercase character and one specical character).</small>
         <small class="help-block" data-fv-validator="stringLength" data-fv-for="password" data-fv-result="NOT_VALIDATED" style="display: none;">Please
          enter a value with valid length</small>
        </div>
        <!-- /field -->
        <div class="field form-group">
         <label for="confirm_password"> Confirm password : </label>
         <input type="password" id="confirm_password" name="confirmPassword" value="" placeholder="Confirm password" class="form-control" data-fv-field="confirmPassword">
         <small class="help-block" data-fv-validator="identical" data-fv-for="confirmPassword" data-fv-result="NOT_VALIDATED" style="display: none;">The
          password are not the same the confirm password.</small>
        </div>
        <!-- /field -->
        <div class="field form-group">
         <label for="birthday"> Birthday : </label>
         <input type="text" id="birthday" name="birthday" value="" placeholder="Birthday (dd/mm/yyyy)" class="form-control" data-fv-notempty="true"
          data-fv-notempty-message="This field is required." data-fv-field="birthday"
         >
         <small class="help-block" data-fv-validator="date" data-fv-for="birthday" data-fv-result="NOT_VALIDATED" style="display: none;">The value is
          not a valid date</small>
         <small class="help-block" data-fv-validator="notEmpty" data-fv-for="birthday" data-fv-result="NOT_VALIDATED" style="display: none;">This field
          is required.</small>
        </div>
        <!-- /field -->
        <div class="field btn-group form-group">
         <a id="gender" class="gender-fields btn btn-default dropdown-toggle btn-select" data-toggle="dropdown" href="#">
          Male
          <span class="caret"></span>
         </a>
         <ul class=" dropdown-menu">
          <li>
           <a> Female</a>
          </li>
          <li class="divider"></li>
          <li>
           <a>
            <span class="glyphicon glyphicon-star"></span>
            Not specified
           </a>
          </li>
         </ul>
        </div>
        Platform Default
        <div class="field btn-group form-group">
         <a id="platformDefault" class="gender-fields btn btn-default dropdown-toggle btn-select" data-toggle="dropdown" href="#">
          Android
          <span class="caret"></span>
         </a>
         <ul class=" dropdown-menu">
          <li>
           <a>iOS</a>
          </li>
          <li class="divider"></li>
          <li>
           <a>Windows Phone</a>
          </li>
         </ul>
        </div>
        <!-- /field -->
       </div>
       <!-- /login-fields -->
       <div class="login-actions form-group">
        <span class="form-group login-checkbox">
         <input id="checktt" name="checktt" type="checkbox" tabindex="4" data-fv-notempty="true" data-fv-notempty-message="You must agree to the terms and conditions."
          data-fv-field="checktt"
         >
         <label for="checktt"> I agree to the <a id="term_condition" style=""> Vmock Terms</a> of User.
         </label>
         <small class="help-block" data-fv-validator="notEmpty" data-fv-for="checktt" data-fv-result="NOT_VALIDATED" style="display: none;">You must
          agree to the terms and conditions.</small>
        </span>
       </div>
       <div class="login-actions form-group">
        <button class="login-action btn btn-primary" style="width: 100%">Register</button>
       </div>
       <!-- .actions -->
      </form>
     </div>
    </div>
   </div>
  </div>
  <!-- /content -->
 </div>
 <!-- /account-container -->
 <!-- Text Under Box -->
 <!-- Placed at the end of the document so the pages load faster -->
 <script src="./PAGE-STYLE/bootstrap/js/vendor/jquery/jquery.min.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/js/bootstrap.min.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/dist/js/formValidation.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/dist/js/framework/bootstrap.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/vendor/bootstrap/js/globaldefine.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/dist/js/bootstrap-datepicker.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/pages/common.js"></script>
 <script src="./PAGE-STYLE/bootstrap/js/pages/signup.js"></script>
</body>
</html>