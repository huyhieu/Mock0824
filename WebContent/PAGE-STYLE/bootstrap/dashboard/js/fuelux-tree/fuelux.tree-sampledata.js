var DataSourceTree = function(options) {
	this._data 	= options.data;
	this._delay = options.delay;
}

DataSourceTree.prototype.data = function(options, callback) {
	var self = this;
	var $data = null;

	if(!("name" in options) && !("type" in options)){
		$data = this._data;//the root tree
		callback({ data: $data });
		return;
	}
	else if("type" in options && options.type == "folder") {
		if("additionalParameters" in options && "children" in options.additionalParameters)
			$data = options.additionalParameters.children;
		else $data = {}//no data
	}
	
	if($data != null)//this setTimeout is only for mimicking some random delay
		setTimeout(function(){callback({ data: $data });} , parseInt(Math.random() * 500) + 200);

	//we have used static data here
	//but you can retrieve your data dynamically from a server using ajax call
	//checkout examples/treeview.html and examples/treeview.js for more info
};

var tree_data = {
	'foodmart' : {name: 'Foodmart', type: 'folder'},
	'seating' : {name: 'Seating', type: 'folder'},
	'flowers' : {name: 'Flowers', type: 'folder'},
	'locations' : {name: 'Locations', type: 'item'},
	'discounts' : {name: 'Discounts', type: 'item'}
}
tree_data['foodmart']['additionalParameters'] = {
	'children' : {
		'appetizer' : {name: 'Appetizer', type: 'item'},
		'main-course' : {name: 'Main Course', type: 'item'},
		'dessert' : {name: 'Dessert', type: 'item'},
		'drinks' : {name: 'Drinks', type: 'folder'}
	}
}
tree_data['foodmart']['additionalParameters']['children']['drinks']['additionalParameters'] = {
	'children' : {
		'hot' : {name: 'Hot Drinks', type: 'item'},
		'cold' : {name: 'Cold Drinks', type: 'folder'}
	}
}
tree_data['foodmart']['additionalParameters']['children']['drinks']['additionalParameters']['children']['cold']['additionalParameters'] = {
	'children' : {
		'iced-tea' : {name: 'Iced Tea', type: 'item'},
		'cold-coffee' : {name: 'Cold Coffee', type: 'item'},
		'milk' : {name: 'Milk', type: 'item'},
		'mango-shake' : {name: 'Mango Shake', type: 'item'},
		'orange-juice' : {name: 'Orange Juice', type: 'item'}
	}
}
tree_data['seating']['additionalParameters'] = {
	'children' : {
		'two-seaters' : {name: 'Two Seaters', type: 'item'},
		'four-seaters' : {name: 'Four Seaters', type: 'item'},
		'eight-seaters' : {name: 'Eight Seaters', type: 'item'}
	}
}
tree_data['flowers']['additionalParameters'] = {
	'children' : {
		'roses' : {name: 'Roses', type: 'item'},
		'lilies' : {name: 'Lilies', type: 'item'},
		'orchids' : {name: 'Orchids', type: 'item'}
	}
}

var treeDataSource = new DataSourceTree({data: tree_data});


var tree_data_2 = {
	'documents' : {name: 'Meat', type: 'folder', 'icon-class':'green'}	,
	'pictures' : {name: 'Milk', type: 'folder', 'icon-class':'red'}	,
	'music' : {name: 'Vegetables', type: 'folder', 'icon-class':'orange'}	,
	'videos' : {name: 'Fruits', type: 'folder', 'icon-class':'blue'}	,
	'contacts' : {name: 'Sodas', type: 'folder'}	,
	'sample-txt' : {name: 'Egg', type: 'item'},
	'sample-zip' : {name: 'Purified Water', type: 'item'},
	'sample-html' : {name: 'Pizza', type: 'item'}
}

tree_data_2['documents']['additionalParameters'] = {
	'children' : [
		{name: 'Pork', type: 'item'},
		{name: 'Beef', type: 'item'},
		{name: 'Chicken', type: 'item'},
		{name: 'Turkey', type: 'item'}
	]
}

tree_data_2['pictures']['additionalParameters'] = {
	'children' : {
		'camera' : {name: 'Wholemilk', type: 'item'},
		'picasa' : {name: 'Chocolate', type: 'item'}
	}
}
tree_data_2['pictures']['additionalParameters']['children']['camera']['additionalParameters'] = {
	'children' : [
		{name: 'Broadern', type: 'item'},
		{name: 'Store brand milk', type: 'item'},
		{name: 'Haleluja Milk', type: 'item'},
		{name: 'Milk Milk', type: 'item'}
	]
}

tree_data_2['music']['additionalParameters'] = {
	'children' : [
		{name: 'Green onion', type: 'item'},
		{name: 'Lectuce head', type: 'item'},
		{name: 'Broccoli', type: 'item'},
		{name: 'Cilantro', type: 'item'},
		{name: 'Cabbage', type: 'item'},
		{name: 'Corn', type: 'item'}
	]
}
tree_data_2['videos']['additionalParameters'] = {
	'children' : [
		{name: 'Apple', type: 'item'},
		{name: 'Orange', type: 'item'},
		{name: 'Banana', type: 'item'},
		{name: 'Pear', type: 'item'},
		{name: 'Grape', type: 'item'}
	]
}

tree_data_2['contacts']['additionalParameters'] = {
	'children' : [
		{name: 'Coke', type: 'item'},
		{name: 'Pepsi', type: 'item'},
		{name: 'Fanta', type: 'item'}
	]
}
var treeDataSource2 = new DataSourceTree({data: tree_data_2});

var tree_data_3 = {
	'weekly-reports' : {name: 'Weekly Reports', type: 'folder'},
	'employees' : {name: 'Employees', type: 'folder'},
	'departments' : {name: 'Departments', type: 'item'},
	'benefits' : {name: 'Benefits', type: 'item'}
}
tree_data_3['weekly-reports']['additionalParameters'] = {
	'children' : {
		'company-sales' : {name: 'Company Sales', type: 'item'},
		'employee-sales' : {name: 'Employee Sales', type: 'item'},
		'foodmart-sales' : {name: 'Foodmart Sales', type: 'item'},
		'product-catalog' : {name: 'Product Catalog', type: 'item'},
		'productline-sales' : {name: 'Product Line Sales', type: 'item'},
		'discounted-sales' : {name: 'Discounted sales', type: 'item'},
		'sales-detail' : {name: 'Sales Order Detail', type: 'item'}
	}
}
tree_data_3['employees']['additionalParameters'] = {
	'children' : {
		'cooks' : {name: 'Cooks', type: 'item'},
		'assistants' : {name: 'Assistants', type: 'item'},
		'waters' : {name: 'Waiters', type: 'item'}
	}
}

var treeDataSource3 = new DataSourceTree({data: tree_data_3});