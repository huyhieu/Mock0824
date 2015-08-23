<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
<!--
.register-success.stacked {
	text-align: center;
}

.register-success {
	background: url("./PAGE-STYLE/bootstrap/img/signup/success_ic.png")
		no-repeat scroll 50% 50% transparent;
	text-align: center;
	vertical-align: middle;
	background-size: 100px;
	height: 500px;
	background-position: top;
}
-->
</style>
<div class="register-success stacked">
 <!-- Loading Box -->
 <div class="modal fade" id="procesingModal" tabindex="-1">
  <div class="modal-dialog processing" style="width: 90%;">
   <div class="modal-content">
    <div class="modal-body">
     <img style="width: 70px; height: 70px" src="./PAGE-STYLE/bootstrap/img/spin.gif">
    </div>
   </div>
  </div>
 </div>
 <!-- /Loading Box -->
 <input id="email" type="hidden" value="">
 <br>
 <br>
 <br>
 <br>
 <br>
 <br>
 <br>
 <p>${msg_annoucement}</p>
 <!-- /content -->
</div>
