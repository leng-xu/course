<template>
    <div>
        <p>
            <button @click="add()" class="btn btn-success">
                <i class="ace-icon fa fa-edit"></i>
                新增
            </button>
            &nbsp;
            <button @click="list(1)" class="btn btn-success">
                <i class="ace-icon fa fa-refresh"></i>
                刷新
            </button>
        </p>
        <table id="simple-table" class="table  table-bordered table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>大章名称</th>
                <th>课程ID</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <tr v-for="chapter in chapters">
                <td>{{chapter.id}}</td>
                <td>{{chapter.name}}</td>
                <td>{{chapter.courseId}}</td>
                <td>
                    <div class="hidden-sm hidden-xs btn-group">
                        <button v-on:click="edit(chapter)" class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>
                        <button v-on:click="del(chapter.id)" class="btn btn-xs btn-danger">
                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                        </button>
                    </div>

                    <div class="hidden-md hidden-lg">
                        <div class="inline pos-rel">
                            <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown"
                                    data-position="auto">
                                <i class="ace-icon fa fa-cog icon-only bigger-110"></i>
                            </button>

                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                <li>
                                    <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																			<span class="blue">
																				<i class="ace-icon fa fa-search-plus bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																			<span class="green">
																				<i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>

                                <li>
                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																			<span class="red">
																				<i class="ace-icon fa fa-trash-o bigger-120"></i>
																			</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>

        <pagination ref="pagination" v-bind:list="list"></pagination>

        <!--新增或者编辑大章模态框-->
        <div class="modal fade" tabindex="-1" role="dialog" id="form-modal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">表单</h4>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">名称</label>
                                <div class="col-sm-10">
                                    <input v-model="chapter.name" class="form-control" placeholder="名称">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">课程ID</label>
                                <div class="col-sm-10">
                                    <input v-model="chapter.courseId" class="form-control" placeholder="课程ID">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="button" class="btn btn-primary" @click="save()">保存</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </div>
</template>

<script>
    import Pagination from "../../components/pagination";

    export default {
        components: {Pagination},
        name: 'chapter',
        data: function () {
            return {
                chapter: {},
                chapters: []
            }
        },
        mounted: function () {//组件每次加载都会执行
            let _this = this;
            _this.$refs.pagination.size = 5;
            _this.list(1);
            // this.$parent.activeSidebar("business-chapter-sidebar"); sidebar 激活样式方法一
        },
        methods: {
            add () {
                let _this = this;
                _this.chapter = {};
                $('#form-modal').modal('show');  // 初始化后立即调用 show 方法
            },

            edit (chapter) {
                let _this = this;
                _this.chapter = $.extend({}, chapter);  // v-model 双向绑定问题
                $('#form-modal').modal('show');  // 初始化后立即调用 show 方法
            },

            list(page) {
                let _this = this;
                _this.$axios.post("http://127.0.0.1:9000/business/admin/chapter/list", {
                    page: page,
                    size: _this.$refs.pagination.size,
                }).then(
                    (response) => {
                        console.log("查询大章结果：", response);
                        let resp = response.data;
                        _this.chapters = resp.content.list;
                        _this.$refs.pagination.render(page, resp.content.total)
                    }
                );
            },

            save() {
                let _this = this;
                _this.$axios.post("http://127.0.0.1:9000/business/admin/chapter/save",
                    _this.chapter).then(
                    (response) => {
                        console.log("保存大章结果：", response);
                        let resp = response.data;
                        if (resp.success) {
                            $('#form-modal').modal('hide');
                            _this.list(1);
                        }
                    }
                );
            },

            del(id) {
                let _this = this;
                _this.$axios.delete("http://127.0.0.1:9000/business/admin/chapter/delete/" + id).then(
                    (response) => {
                        console.log("删除大章结果：", response);
                        let resp = response.data;
                        if (resp.success) {
                            _this.list(1);
                        }
                    }
                );
            }
        }
    }
</script>