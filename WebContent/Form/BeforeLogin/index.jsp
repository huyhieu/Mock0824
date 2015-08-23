<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<title>jQuery treeview</title>

<link rel="stylesheet"
	href="./PAGE-SCRIPT/jquery/treeview/jquery.treeview.css" />
<script src="./PAGE-SCRIPT/jquery/treeview/jquery.treeview.js"
	type="text/javascript"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#browser").treeview({
			toggle : function() {
				console.log("%s was toggled.", $(this).find(">span").text());
			}
		});
	});
</script>
</head>
<body>
	<div id="main">
		<ul id="browser" class="filetree treeview-famfamfam">
			<li><span class="folder">Folder 1</span>
				<ul>
					<li><span class="folder">Item 1.1</span>
						<ul>
							<li><span class="file">Item 1.1.1</span></li>
						</ul></li>
					<li><span class="folder">Folder 2</span>
						<ul>
							<li><span class="folder">Subfolder 2.1</span>
								<ul id="folder21">
									<li><span class="file">File 2.1.1</span></li>
									<li><span class="file">File 2.1.2</span></li>
								</ul></li>
							<li><span class="folder">Subfolder 2.2</span>
								<ul>
									<li><span class="file">File 2.2.1</span></li>
									<li><span class="file">File 2.2.2</span></li>
								</ul></li>
						</ul></li>
					<li class="closed"><span class="folder">Folder 3
							(closed at start)</span>
						<ul>
							<li><span class="file">File 3.1</span></li>
						</ul></li>
					<li><span class="file">File 4</span></li>
				</ul></li>
		</ul>
	</div>
</body>
</html>