<%@include file="header.jsp" %>
<link href='<c:url value="/css/metisMenu.min.css" />' rel="stylesheet" type="text/css"/>
<link href='<c:url value="/css/dataTables.bootstrap.css" />' rel="stylesheet" type="text/css"/>
<link href='<c:url value="/css/warana/pages-commons.css" />' rel="stylesheet" type="text/css"/>
<link href='<c:url value="/css/font-awesome.min.css" />' rel="stylesheet" type="text/css"/>
<link href='<c:url value="/css/bootstrap-tagsinput.css" />' rel="stylesheet" type="text/css"/>
<link href='<c:url value="/css/warana/modal-style.css" />' rel="stylesheet" type="text/css"/>
<link href='<c:url value="/css/warana/view-stat.css" />' rel="stylesheet" type="text/css"/>

<script src='<c:url value="/js/metisMenu.min.js" />' type="text/javascript"></script>
<script src='<c:url value="/js/jquery.dataTables.js" />' type="text/javascript"></script>
<script src='<c:url value="/js/dataTables.bootstrap.js" />' type="text/javascript"></script>
<script src='<c:url value="/js/sb-admin-2.js" />' type="text/javascript"></script>
<script src='<c:url value="/js/warana/view-stat.js" />' type="text/javascript"></script>


<script src='<c:url value="/js/bootstrap-tagsinput.js" />' type="text/javascript"></script>
<script src='<c:url value="/js/typeahead-new.js" />' type="text/javascript"></script>


<div id = "wrapper">
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="dash-board-title">View Statistics</h1><hr style="margin-bottom:40px">
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12" >
                <div class="panel panel-green">
                    <div class="panel-heading">
                        User Statistics
                    </div>
                    <div class="panel-body">
                        <div id = "select-all-row">
                            <h4 style="margin-left: 10px"><input type="checkbox" id = "select-all" style="margin-right: 10px"/>Select All</h4>
                        </div>
                        <div class="table-responsive" id="stat-table-div"></div>
                        <div id="advanced-search-panel" style="margin-top: 50px">
                            <div id="headingOne">
                                <h4>
                                    <a data-toggle="collapse" data-parent="#accordion" href="#advancedSearch" aria-expanded="true" aria-controls="collapseOne"  style="color: #0f0f0f">
                                        Advanced Search
                                    </a>
                                </h4>
                            </div>
                            <div id="advancedSearch" class="panel-collapse collapse" aria-labelledby="headingOne">
                                <div>
                                    <input id="tagged-search-field" type="text" data-provide="typeahead"/>
                                    <button type="submit" class="btn btn-primary" style="margin-top: -10px" id="search-submit">Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <div class="process-btn-div">
                            <button type="button" id="clear-selection" class="btn btn-warning btn-center" style="margin-right: 10px;">
                                <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span> Clear
                            </button>
                        </div>
                    </div>
                </div>
                <!-- /.col-lg-4 -->
            </div>
        </div>

        <%@include file="view-profile-modal.jsp" %>
    </div>
</div>

<%@include file="footer.jsp" %>