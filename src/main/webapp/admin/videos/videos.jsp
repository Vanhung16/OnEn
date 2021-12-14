<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditting-tab" data-toggle="tab"
			href="#videoEditting" role="tab" aria-controls="videoEditting"
			aria-selected="true">Video Editting</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="tab" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">Video List</a></li>

	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditting"
			role="tabpanel" aria-labelledby="videoEditting-tab">
			<form action="" method="post">
				<div class="card">

					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<!-- <div class="row"> -->
								<div class="border p-3">
									<img src="../image/iphone-12-didongviet-1.jpg" alt=""
										class="img-fluid">
								</div>
								<!-- </div> -->
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="youtubeId">Youtube ID</label> <input type="text"
										class="form-control" name="youtubeId" id="youtubeId"
										aria-describedby="youtubeIdHid" placeholder="Youtube ID">
									<small id="youtubeIdHid" class="form-text text-muted">Youtube
										ID is required!</small>
								</div>
								<div class="form-group">
									<label for="videoTitle">Video Title</label> <input type="text"
										class="form-control" name="videoTitle" id="videoTitle"
										aria-describedby="videoTitleHid" placeholder="Video Title">
									<small id="videoTitleHid" class="form-text text-muted">Video
										Title is required!</small>
								</div>
								<div class="form-group">
									<label for="viewCount">View Count</label> <input type="text"
										class="form-control" name="viewCount" id="viewCount"
										aria-describedby="viewCountHid" placeholder="View Count">
									<small id="viewCountHid" class="form-text text-muted">View
										Count is required!</small>
								</div>
								<div class="form-check form-check-inline">
									<label> <input type="radio" value="true" name="status"
										id="status" class="form-check-input">Active
									</label> <label class="ml-3"> <input type="radio" value="false"
										name="status" id="status" class="form-check-input">Inactive
									</label>
								</div>
							</div>
						</div>
						<div class="row">
							<label for="description">Description</label>
							<textarea name="description" id="description"
								class="form-control" cols="30" rows="5"></textarea>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-success">Create</button>
						<button class="btn btn-warning">Update</button>
						<button class="btn btn-danger">Delete</button>
						<button class="btn btn-info">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-striped">
				<tr>
					<td>Youtube ID</td>
					<td>Video Title</td>
					<td>View Count</td>
					<td>Status</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>YTT</td>
					<td>Java Programming</td>
					<td>105</td>
					<td>Active</td>
					<td><a href=""> <i class="fa fa-edit" aria-hidden="true"></i>Edit
					</a> <a href=""> <i class="fa fa-trash" aria-hidden="true"></i>Delete
					</a></td>
				</tr>
			</table>
		</div>
	</div>
</div>