package com.todoapplication.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.todoapplication.constants.InquiryConstants;
import com.todoapplication.models.Tasks;
import com.todoapplication.service.TaskCrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = InquiryConstants.REQ_MAPPING_GET_TASKS, tags = "Tasks", produces = "application/json, application/xml")
public class TasksRestController {

	@Autowired
	TaskCrudService taskCrudService;

	@ApiOperation(value = "Provide All Task Details ", notes = "Returns Task Details in JSON / XML format", httpMethod = "GET", nickname = "getAllTasks")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Returns Task Details"),
			@ApiResponse(code = 400, message = "Bad Request: The request could not be understood by the server due to malformed syntax"),
			@ApiResponse(code = 401, message = "Unauthorized: The request requires user authentication"),
			@ApiResponse(code = 403, message = "Forbidden: The server understood the request, but is refusing to fulfill it"),
			@ApiResponse(code = 404, message = "Not Found: The server has not found anything matching the Request-URI"),
			@ApiResponse(code = 412, message = "Precondition Failed: The precondition given in one or more of the request-header fields evaluated to false"),
			@ApiResponse(code = 500, message = "Error While Trying To Fetching Tasks")

	})
	@RequestMapping(value = InquiryConstants.REQ_MAPPING_GET_TASKS, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Collection<Tasks> tasks() {
		return taskCrudService.getAllTasks();
	}

	@ApiOperation(value = "Get Task Details By Id", notes = "Get Task Details in JSON / XML format", httpMethod = "GET", nickname = "getAllTasks")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Get Task Details By Id"),
			@ApiResponse(code = 400, message = "Bad Request: The request could not be understood by the server due to malformed syntax"),
			@ApiResponse(code = 401, message = "Unauthorized: The request requires user authentication"),
			@ApiResponse(code = 403, message = "Forbidden: The server understood the request, but is refusing to fulfill it"),
			@ApiResponse(code = 404, message = "Not Found: The server has not found anything matching the Request-URI"),
			@ApiResponse(code = 412, message = "Precondition Failed: The precondition given in one or more of the request-header fields evaluated to false"),
			@ApiResponse(code = 500, message = "Error While Fetching Tasks Details By Id")

	})
	@ApiImplicitParams({
			@ApiImplicitParam(name = InquiryConstants.PARAM_TASK_ID, value = "taskId", required = true, dataType = "string", paramType = "query") })
	@RequestMapping(value = InquiryConstants.REQ_MAPPING_GET_TASKS_BY_ID, method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Tasks getTaskById(@RequestParam(value = InquiryConstants.PARAM_TASK_ID, required = true) final long id) {
		return taskCrudService.getTaskById(id);
	}

	@ApiOperation(value = "Add Task Details", notes = "Add Task Details in JSON / XML format", httpMethod = "POST", nickname = "addTasks")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Add Task Details"),
			@ApiResponse(code = 400, message = "Bad Request: The request could not be understood by the server due to malformed syntax"),
			@ApiResponse(code = 401, message = "Unauthorized: The request requires user authentication"),
			@ApiResponse(code = 403, message = "Forbidden: The server understood the request, but is refusing to fulfill it"),
			@ApiResponse(code = 404, message = "Not Found: The server has not found anything matching the Request-URI"),
			@ApiResponse(code = 412, message = "Precondition Failed: The precondition given in one or more of the request-header fields evaluated to false"),
			@ApiResponse(code = 500, message = "Error While Adding Tasks Details")

	})
	@RequestMapping(value = InquiryConstants.REQ_MAPPING_ADD_TASKS, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveTask(@RequestBody @Valid Tasks task) {
		taskCrudService.saveTask(task);
	}

	@ApiOperation(value = "Delete Task Details", notes = "Delete Task Details in JSON / XML format", httpMethod = "DELETE", nickname = "deleteTasks")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete Task Details"),
			@ApiResponse(code = 400, message = "Bad Request: The request could not be understood by the server due to malformed syntax"),
			@ApiResponse(code = 401, message = "Unauthorized: The request requires user authentication"),
			@ApiResponse(code = 403, message = "Forbidden: The server understood the request, but is refusing to fulfill it"),
			@ApiResponse(code = 404, message = "Not Found: The server has not found anything matching the Request-URI"),
			@ApiResponse(code = 412, message = "Precondition Failed: The precondition given in one or more of the request-header fields evaluated to false"),
			@ApiResponse(code = 500, message = "Error While Deleting Tasks Details")

	})
	@ApiImplicitParams({
			@ApiImplicitParam(name = InquiryConstants.PARAM_TASK_ID, value = "taskId", required = true, dataType = "string", paramType = "query") })
	@RequestMapping(value = InquiryConstants.REQ_MAPPING_DELETE_TASKS, method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void deleteTask(@RequestParam(value = InquiryConstants.PARAM_TASK_ID, required = true) final long id) {
		taskCrudService.deleteTask(id);
	}

	@ApiOperation(value = "Update Task Details", notes = "Update Task Details in JSON / XML format", httpMethod = "PUT", nickname = "updateTasks")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Delete Task Details"),
			@ApiResponse(code = 400, message = "Bad Request: The request could not be understood by the server due to malformed syntax"),
			@ApiResponse(code = 401, message = "Unauthorized: The request requires user authentication"),
			@ApiResponse(code = 403, message = "Forbidden: The server understood the request, but is refusing to fulfill it"),
			@ApiResponse(code = 404, message = "Not Found: The server has not found anything matching the Request-URI"),
			@ApiResponse(code = 412, message = "Precondition Failed: The precondition given in one or more of the request-header fields evaluated to false"),
			@ApiResponse(code = 500, message = "Error While Updating Tasks Details")

	})
	@ApiImplicitParams({
			@ApiImplicitParam(name = InquiryConstants.PARAM_TASK_ID, value = "taskId", required = true, dataType = "string", paramType = "query") })
	@RequestMapping(value = InquiryConstants.REQ_MAPPING_UPDATE_TASKS, method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void editTask(@RequestBody @Valid Tasks editedTask,
			@RequestParam(value = InquiryConstants.PARAM_TASK_ID, required = true) final long id) {
		taskCrudService.editTask(editedTask, id);
	}

}