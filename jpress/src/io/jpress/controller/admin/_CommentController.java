/**
 * Copyright (c) 2015-2016, Michael Yang 杨福海 (fuhai999@gmail.com).
 *
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jpress.controller.admin;

import com.jfinal.plugin.activerecord.Page;

import io.jpress.core.JBaseCRUDController;
import io.jpress.core.annotation.UrlMapping;
import io.jpress.model.Comment;
import io.jpress.template.Module;

@UrlMapping(url = "/admin/comment", viewPath = "/WEB-INF/admin/comment")
public class _CommentController extends JBaseCRUDController<Comment> {

	private String getContentModule() {
		String module = getPara("m");
		if (null == module || "".equals(module)) {
			module = Module.ARTICLE;
		}
		return module;
	}

	private String getType() {
		return getPara("t");
	}
	
	@Override
	public Page<Comment> onIndexDataLoad(int pageNumber, int pageSize) {
		return mDao.doPaginate(pageNumber, pageSize, getContentModule(), getType());
	}

}
