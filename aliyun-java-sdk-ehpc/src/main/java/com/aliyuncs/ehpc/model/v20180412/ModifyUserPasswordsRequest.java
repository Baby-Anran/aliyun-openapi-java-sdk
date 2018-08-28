/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliyuncs.ehpc.model.v20180412;

import com.aliyuncs.RpcAcsRequest;
import java.util.List;

/**
 * @author auto create
 * @version 
 */
public class ModifyUserPasswordsRequest extends RpcAcsRequest<ModifyUserPasswordsResponse> {
	
	public ModifyUserPasswordsRequest() {
		super("EHPC", "2018-04-12", "ModifyUserPasswords", "ehs");
	}

	private String clusterId;

	private List<User> users;

	public String getClusterId() {
		return this.clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
		if(clusterId != null){
			putQueryParameter("ClusterId", clusterId);
		}
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;	
		if (users != null) {
			for (int depth1 = 0; depth1 < users.size(); depth1++) {
				putQueryParameter("User." + (depth1 + 1) + ".Password" , users.get(depth1).getPassword());
				putQueryParameter("User." + (depth1 + 1) + ".Name" , users.get(depth1).getName());
			}
		}	
	}

	public static class User {

		private String password;

		private String name;

		public String getPassword() {
			return this.password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	@Override
	public Class<ModifyUserPasswordsResponse> getResponseClass() {
		return ModifyUserPasswordsResponse.class;
	}

}
