<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
<!--
select.httpmethor {
	display: block;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.428571429;
	color: #555;
	vertical-align: middle;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	margin-right: 5px;
}

input.urlContent {
	display: block;
	height: 34px;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.428571429;
	color: #555;
	vertical-align: middle;
	background-color: #fff;
	background-image: none;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
	transition: border-color ease-in-out .15s, box-shadow ease-in-out .15s;
	margin-right: 5px;
}
-->
</style>
<div class="col-xs-12 col-md-12">
 <div>
  <section>
   <div class="useCase">
    <span>Use Case</span>
    <div class="col-xs-12 col-md-12">
     <div class="col-xs-9 col-md-9">
      <input type="text" class="form-control col-xs-12 col-md-12" placeholder="name">
      <span>
       Service:
       <a href="#void" class="btn btn-link btn-mini" id="gwt-uid-41" data-original-title="" title="">
        <i></i>
        Home
       </a>
      </span>
      <span>
       Project:
       <a href="#void" class="btn btn-link btn-mini" id="gwt-uid-42" data-original-title="" title="">
        <i></i>
        ViettelStore
       </a>
      </span>
     </div>
     <div class="col-xs-3 col-md-3">
      <div>
       <a href="#void" class="btn btn-info btn-small">
        <i class="icon-download-alt"></i>
        Save
       </a>
       <a href="#void" class="btn btn-info btn-small">
        <i class="icon-file-text"></i>
        2 Code
       </a>
       <a href="#void" class="btn btn-danger btn-small">
        <i class="icon-trash"></i>
        Reset
       </a>
      </div>
     </div>
    </div>
   </div>
  </section>
  <section class="pane" id="request">
   <span>Request</span>
   <div class="content">
    <div class="service" id="request">
     <span class="col-xs-12 col-md-12">
      <span class="protocol">
       <select class="httpmethor col-xs-1 col-md-1" style="width: 10%;">
        <option value="http">http</option>
        <option value="https">https</option>
       </select>
      </span>
      <span class="">
       <input type="text" class="urlContent col-xs-9 col-md-9" placeholder="type an URI">
      </span>
      <span class="cell http-method"> </span>
      <span class="cell">
       <a href="#void" class="btn btn-send btn-success">
        <i class="icon-send"></i>
        Send
       </a>
      </span>
     </span>
    </div>
   </div>
  </section>
 </div>
</div>