<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="register stacked">
	<div class="row">
		<div class="row-same-height">
			<div class="col-sm-5 col-xs-12 col-md-6 col-lg-6 col-xlg-6">
				<h3>Đăng nhập Vmock</h3>

				<div class="form-login">
					<form:form id="regiter_form" action="dologin.html" method="post" novalidate="novalidate" class="fv-form fv-form-bootstrap">
						<button type="submit" class="fv-hidden-submit" style="display: none; width: 0px; height: 0px;"></button>
						<div class="login-fields">
							<div class="regist-has-error">${msg_loginFail}</div>
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
								<form:label path="userEmail" for="email"> Email : </form:label>
								<form:input path="userEmail" type="text" id="email" name="email" value="hieunq5@viettel.com.vn" placeholder="Email" class="form-control" data-fv-emailaddress="true" data-fv-notempty="true"
									data-fv-notempty-message="This field is required." data-fv-field="email" />
								<small class="help-block" data-fv-validator="emailAddress" data-fv-for="email" data-fv-result="NOT_VALIDATED" style="display: none;">Please enter a valid email address</small> <small
									class="help-block" data-fv-validator="notEmpty" data-fv-for="email" data-fv-result="NOT_VALIDATED" style="display: none;">This field is required.</small>
							</div>
							<!-- /field -->
							<div class="field form-group">
								<form:label path="userPassword" for="password"> Password : </form:label>
								<form:input path="userPassword" type="password" id="password" name="password" value="123456aA@" placeholder="Password" class="form-control" data-fv-notempty="true" data-fv-stringlength="true"
									data-fv-stringlength-max="30" pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[`~!@#$%^&amp;*()_|+\-=?;:',.<>\{\}\[\]\\\/]).{8,30})"
									data-fv-regexp-message="This field must contain at least 8 characters (at least one number, at least one uppercase character, at least one lowercase character  and one specical character)."
									data-fv-notempty-message="This field is required." data-fv-field="password" />
								<small class="help-block" data-fv-validator="notEmpty" data-fv-for="password" data-fv-result="NOT_VALIDATED" style="display: none;">This field is required.</small> <small class="help-block"
									data-fv-validator="regexp" data-fv-for="password" data-fv-result="NOT_VALIDATED" style="display: none;">This field must contain at least 8 characters (at least one number, at least
									one uppercase character, at least one lowercase character and one specical character).</small> <small class="help-block" data-fv-validator="stringLength" data-fv-for="password"
									data-fv-result="NOT_VALIDATED" style="display: none;">Please enter a value with valid length</small>
							</div>
							<!-- /field -->
						</div>
						<div class="login-actions form-group">
							<input class="login-action btn btn-primary" type="submit" style="width: 100%" value="Login" />
						</div>
						<p class="lost-password">
							Bạn quên mật khẩu? <a href="./forgotPassword.html">Click vào đây</a>
						</p>
						<!-- .actions -->
					</form:form>

				</div>
				<div class="signup-box">
					<h3>Bạn chưa có tài khoản?</h3>

					<button class="btn btn-large" style="margin-bottom: 20px; margin-top: 10px;" onclick="window.location.href='./register.html'">Tạo tài khoản</button>

					<!-- <p>
						hoặc <strong>đăng nhập với tài khoản</strong>
					</p> -->
					<!--<p class="login-social">-->
					<div class="login-socail-network" style="display: none;">
						<a class="btn-facebook" onclick="fb_login()"><span><img
								src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABUAAAAbCAMAAACkwzTUAAAAZlBMVEX///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////+rG8stAAAAIXRSTlMAAwkMECQvQExVY2x5gJGZoKapqq24vMzQ3Obn8PX3/f7+zCJAAAAAX0lEQVQoz8XRNw6AMBBEUYLJyeQc/v0vSYVkDBIVMOUrZlcaw/gnXjPDoGGwAkxnNEdu1AWWNIm0VqC63gKkZpmsgV7KWFWOdM+6HdqqagsfyIWwnn/4Wp2iLMPXl90BimgMLszYgpgAAAAASUVORK5CYII=">Facebook</span></a>
						<a class="btn-google-plus" onclick="google_login()"><span><img
								src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABkAAAAbCAMAAAC+/9RaAAABIFBMVEX///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////9zlAINAAAAX3RSTlMAAQMEBgkKCw4SExobHB4jKCotLi8yMzQ1Nz5AQkVHSktPUVJVWFliaXJzdHt9hYeLjpCTlJWWl5iZnJ+goqSoqquwsbK6w8XGyMnP09XW2d3f4eLk6ezv8PHz9vf4+vpYxDwAAADaSURBVCjPY2CgLxAy8w6JiIiwYkKX0PIR47aID+LH0CEfr8zAwOgWb4sh4xovDCQV42MxZALjFYAkT3w8C7qMR7w5kGSNd8fQoxofKwIkoyWAbH1TFCnNqEgT61BJENPIBlUXq6hjvDGQNnQKCHayRJUziw8TY2DQNvL2M9JFFueU0o2Pj1HCME3S1V9PTcUnPg7oBF0DJAm5OHtmIMXmEu+A5mjfeD4wzRHuiSYTH88LYXijuZjBO96KEUQLRAqiyYiHxXtpyMjq+EhjhA6XlrOnm506O8OgAgAsOiC5P7fhOAAAAABJRU5ErkJggg==">Google</span></a>
						<a class="btn-linkedin" onclick="linkedin_login()"><span> <img src="./PAGE-STYLE/images/SocialNetwork/xicon-linkedin.png.pagespeed.ic.oe6TxRC8ZD.png">LinkedIn
						</span></a>
					</div>
					<!--</p>-->
				</div>

			</div>
			<div class="hidden-xs col-sm-6 col-xs-6 col-md-6 col-lg-6 col-xlg-6">
				<div class="quick-guide span5 offset1">
					<h3 class="bottom-line-grey">Tại sao chọn Vmock?</h3>
					<p>- Ngành nghề đa đạng.</p>
					<p>- Giao dịch an toàn.</p>
					<p>- Cạnh tranh công bằng, thù lao tương xứng.</p>
					<p>- Chi phí thấp.</p>
					<div class="small-pic">
						<span> <img
							src="data:image/webp;base64,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">
						</span> <span> <img
							src="data:image/webp;base64,UklGRvICAABXRUJQVlA4IOYCAADwEQCdASpRAFEAPm0ylkikIqIhIrVa6IANiWkAEKq3p3sBlBGHP9JbTZgn/N/tX5Ae036F/5vuDfyj+kf871dPWX+1XsJ/r2PKtnBes53dlTq7AwxqkLwuCUz6n96dyXnhAbpMOYA5FIfvIvX8ooN2NbfOr58jqmiN1lq+0j1FHLCtQwbtUWZqEOYJvUgKpvtIhzzDe0nDMAD+/f0Cav36SdbTAmeMpuwqMLGkxFXoR/TAFlV9UK81KluCjk6mX0d/Oev+6+WAm2fdYrBSNj1riKn+jVg6pOgL/kpyUYylrE8Wfb+Y3naIeA6NazdaoVyvkUMAJxdG1xhgW5z8BeZ5YVRK9qFFnZSYCLkWriTFA+pZ2BUdUbPIbE5cqU50/5Y34c/fEqPQXe14CwPfVjwFyYyB5Gvophq/cp45RQK4AXvRcZG2Ug3/1CR26e4gyh7Ah5djxqV+GZME363+qD1kD4JwaYC/vwDTVlom8Z+OMe/OrK40DEvHDJBeW6lPtscsNC+dlSNl7CE++WtFAYwrVo7F7gGyiFS4sszwOnt1SAxn4EZABkbU5Ox4sdS94qSlBGVcNBztX3ExWdt8JseTw4LP7b6sILucZImHO7sS3rfu0Q4+Mq/hKxZdZAy0srPpcztzN8IUD8vsxmTPfnSOcBjpuLZwYOxLynBIsaknPQg8z1xsdl9QNQFuiG8m01Z5g/9QTMJ15dRz1/+4g5cD4nC6DBot4NKiNx33bZEoWmzEAI0QL9zjwahhnq2V8FpxA4e/bviqMULE4YCNNzVHTriycJIhWhJIt6F91f/p09vhp4x0mwfT+7q6U5FoVW3C7NEywmpQL7xuqDqHYUftJMn7CC4987oKXXVh/4SJ+DYvCyObcnIW+lgHLjU5WZ4T4A+YKohg/hhM5frPz5arKIufsKXAxFJRUer15pfnEAsYWDwvw2Iy64TyG6QoDyG/jjluYQ5gauBHj383XeYAcGQgAAAA">
						</span> <span> <img
							src="data:image/webp;base64,UklGRnwEAABXRUJQVlA4IHAEAADQGQCdASpRAFEAPm00lEgkIqIho5QMOIANiWkAFtPtB6wj2L8j+T2yG/JcKO1X/kN6o5H/Lf9Pxk9t3x7/jPsAfx7+9f8D2T/6b/ueVn8x/yf/J/x/wB/x3+i/7X+4fu98Unr0/XL2If05LcV/z0kUPO4/z8MR9RfzN6b6sNki8Ic/8vszF+z90ugMTxgsaP1HoC2zUKXvuv6wDoRMK0+9SqKJtaqTcTga7tw6wkQ8Y3krDwX1HEeqpLpxy9syejVMxuTZmeMUpDQzb2ZUTvcMFwBBWOBYAAD+/4msxN8NBkFPOtOQ3cmfuGAYrRcljA9dpS0ml4ZdiFmM1QYLEMxS/v/Et68sMFs1NaftatweoI3u3X5utzAojtZsbTnACx/CwT0l2r+nLfA3O2wnBc7QT7R8e20eNAc5vRgZXUqXzd/B8UAmSARZugquugOxnHXSKzboriWcGIulh1x0WJoRIknvViZLe7duW1OVF8xNrviW7aX4wuQDLN6dKLfSZ+lj/JncGvd9V2e2P/41HsqEKKgR9HwMm5zI/6b8vZ90sJWatPMuJEOnGtVazcphA90fTVdVvyq4TLn1BZFVdcVhR4O9mGqH78D7qp9qKKrZ/t1x8gObTBsiN4yhC8oChDub3hSfLq5M+PQWnHRF4pBmWuR+uO50mB7lyRMgy1xs9UsHaxdLxUlTVEUzmYJ4FWbmq787+vBUwb/+MUgR3g7s6C8RAoFzoY27SNCGvPVrfK8Y56vR5qAQGzo/R+ULrC7/2FccARz6BO7OZ79zstigNSvI8HfglqMWtFlc/LspOzpHLTWWap3+fc4vmo+ZRlyvcmQb/3f0ba/46702NVDCvK7mR23vDa3xslrC3J3bn1TrOoceT23vhkOR7wp76RUR3z41rPHNqPX6aoLhwJYMJcSaggMhc1U5hhykHeXK1oWaEzQcrZNIjm6VAUKSTuHkE8BHufZJ85r9IFbT3GHJpytZqARRlphjS8G/bxcG+WMepCEVSJhk4iskrBa2p2rcAaR485rMOcV3/Ew8vPMUmZPEKWNYAxnKQV+SWNBEGTeirZfs4y+1dUBkK7SS9Wie2ZI8sLdhlVEDYNMn4LxlplzNN69iqRd2dU8J+vRvMR1nsf1XLd1u2e1/5jtr3O+LjFfjfdB3BBHBhDUfqbmHxsKE51WTXb3qp99EeeKZcg+obNeiSE4ch9/cXrKx/4/9yJXVl/WTNAHjndxbmCt3KfL/v95h88+eshCV0JqxF65eLuF/wXxoDB+3301te9ANp0wOW6RIB7/8PFP/7/beOOkgi1ld4JFbdakQHXD/DY2weuTXy9YNihRGB01sEFkci30NugrnDHj/xZNABRuECjYK1O7DVeEA82lIZiQbwJncE7rcLB52utET96vUkrYbR/IKCqrymv7ya2xCa4ilI1JtjLT8N853rIimEcUZUC0axEysSXJNfVXE5StbbIfJh2CK0pdXH6RCmN8f99VywRzl/w9Hh1mTBMhsYAAAAA==">
						</span> <span> <img
							src="data:image/webp;base64,UklGRkQDAABXRUJQVlA4IDgDAAAQFACdASpRAFEAPm0ylUikIqIhI5QKgIANiWkAFtVq2cLtyA2U8UG1LutmRf9V4Npb/hN/2/3AfI9/l+WL6X/4v93+AX+U/1j/idiD0Lf02Hm/dXo6VPvxeppND2DZN9XSQ5sIdCB0ahmK0OwsB9SgmqthfksWKlqSftqLfRoE8P9PtwItShM2GwfzwSdXQxDzTyUmavErTi9GzuB7Nwmphm5+bxkD2VwAAP7/kYjUMCMhnDScKw9p1YW/UR86v+J+P7z2oy9+iCKy16dIbcC+IrvnXcs+UnFi8ljiRUd8CxYG0NcEGN1sRcKOBOhhnkH9dtG4LrAt6EHMmqDcdT8ND2cB82ZGKET6OQl5zcfPnQ2fo+0nlpHR/7tDQ3DBxof3PiwyNhpkzyKv71LtL5Y4c/3l9H7aML3Satm5222vKWg6c7PsZwwVcSVawN1iLrltpkW3NhsdNaFdwKqgFxlGMLN4hRBhNPiY7plkunR+hwAFwcUixf+k6uURwrltv5u1b2zc8N1dB44oLw/FC9Cvt8uy6xCl3KRgsAnDLe4xSr1u5XM32iRaUyfQFQpO+XmzMwY1fEOe1lI3QwzohlAJIlr5KGwBm7veYiC4cTPlbTjUZItc0q8bxL5z3hDp2bcvlaiqgE4Wgt0CDnvJemV8v5IYga/8P87ZFQblNRgGupaxVLd48hurJIyhGfJnLcYxESafX4gXPMFwufcDU/G+ohqK0zJBT9tEUkhZ6SXm/N8AgCexHdOCOoKqZVLL937Io9ga2/7+/4owP9ij+b8OADCynxZ7SIu/9pASaXIB8xPsdv/0kV/t647uWYuPAREf2eIVvP/jagTXsKgXdbaiX9UVD/4+0lXlZHUiYJreyYM6fqiRxcZ4GbDZB2xEICPDyYuWJ+6FOLy65/njnqdpYMslDgBXmcEJ69xd3EeKGp51gjQYdnWEkaDxwdmAiWaxCBHYz47EYhWL1l3vFr46WJG8zhfvnkIVyV79N25jmAz16wunOqIaXFe6CN4d3vRLZ+ddGMhpur6BTavYIS6aaepgW0ZDL4NLSPa2E4C3DLfrSylN2JTWBLw/xybtu0VdKUpdgAAAAA=="
							alt="">
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /content -->
</div>