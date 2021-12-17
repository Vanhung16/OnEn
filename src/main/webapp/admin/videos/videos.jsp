<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
	<jsp:include page="/common/inform.jsp"></jsp:include>
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
			<form action="" method="post" enctype="multipart/form-data">
				<div class="card">

					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<!-- <div class="row"> -->
								<div class="border p-3">
									<img src="${video.poster != null?video.poster: 'images/desktop.jpg' }" alt="" class="img-fluid">
									<div class="input-group mb-3 mt-3">
										<span class="input-group-text">Upload</span>
									</div>
									<div class="custom-file">
										<input type="file" class="custom-file-input" id="cover" name="cover">
										<label for="cover">Choose File</label>
									</div>
								</div>
								<!-- </div> -->
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="youtubeId">Youtube ID</label> <input type="text"
										class="form-control" name="videoId" id="youtubeId" value="${video.videoId }"
										aria-describedby="youtubeIdHid" placeholder="Youtube ID">
									<small id="youtubeIdHid" class="form-text text-muted">Youtube
										ID is required!</small>
								</div>
								<div class="form-group">
									<label for="videoTitle">Video Title</label> <input type="text"
										class="form-control" name="title" id="videoTitle" value="${video.title }"
										aria-describedby="videoTitleHid" placeholder="Video Title">
									<small id="videoTitleHid" class="form-text text-muted">Video
										Title is required!</small>
								</div>
								<div class="form-group">
									<label for="viewCount">View Count</label> <input type="text"
										class="form-control" name="views" id="viewCount" value="${video.views }"
										aria-describedby="viewCountHid" placeholder="View Count">
									<small id="viewCountHid" class="form-text text-muted">View
										Count is required!</small>
								</div>
								<div class="form-check form-check-inline">
									<label> <input type="radio" value="true" name="active" value="${video.active? 'checked':'' }"
										id="status" class="form-check-input">Active 
									</label> 
									<label class="ml-3"> <input type="radio" value="false" value="${!video.active? 'checked':'' }"
										name="active" id="status" class="form-check-input">Inactive
									</label>
								</div>
							</div>
						</div>
						<div class="row">
							<label for="description">Description</label>
							<textarea name="description" id="description"
								class="form-control" cols="30" rows="5">${video.description }</textarea>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-success" formaction="Admin/VideosManagement/create">Create</button>
						<button class="btn btn-warning" formaction="Admin/VideosManagement/update">Update</button>
						<button class="btn btn-danger" formaction="Admin/VideosManagement/delete">Delete</button>
						<button class="btn btn-info" formaction="Admin/VideosManagement/reset">Reset</button>
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
				<c:forEach var="item" items="${videos }">
				<tr>
					<td>${ item.videoId}</td>
					<td>${ item.title}</td>
					<td>${ item.views}</td>
					<td>${ item.active?'Active': 'Deactive'}</td>
					<td>
					<a href="Admin/VideosManagement/edit?videoId=${item.videoId }"> <i class="fa fa-edit" aria-hidden="true"></i>Edit
					</a>
					 <a href="Admin/VideosManagement/delete?videoId=${item.videoId }"> <i class="fa fa-trash" aria-hidden="true"></i>Delete
					</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>