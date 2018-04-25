<!DOCTYPE html>
<html ng-app='ToDoListApp'>
<head>
<title>TODO-List-app</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/datetimepicker.css" />
</head>
<body>
	<div ng-view></div>

	<script src="js/angular.min.js"></script>
	<script src="js/angular-route.min.js"></script>
	<script src="js/angular-resource.min.js"></script>
	<script src="js/ui-bootstrap-tpls-1.3.1.min.js"></script>
	<script src="js/datetimepicker.js"></script>

	<script src="app.js"></script>

	<script src="controllers/tasksControllers.js"></script>
	<script src="services/tasksFactories.js"></script>

	<script src="controllers/DateTimePickerController.js"></script>
</body>
</html>