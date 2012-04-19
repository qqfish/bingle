package businessServices.datamanager.userdata;

import baseUse.*;


public interface IUserData {
	/** @param username 
	    * @param password
	    * @pdOid 71771432-8b9b-4438-86fa-ebc216acf3f2 */
	   Boolean confirmUser(String username, String password);
	   /** @param username 
	    * @param groupname
	    * @pdOid 8fba25a5-930b-4721-8711-c06b81cbe8ff */
	   void changeUserGroup(String username, String groupname);
	   /** @param username 
	    * @param friendname
	    * @pdOid 6e9b8e59-5649-46ff-bb86-603ce54d971c */
	   void addFriend(String username, String friendname);
	   /** @param username 
	    * @param friendname
	    * @pdOid 6e3ed02a-a70e-4b06-9db5-b27ef6c1728a */
	   void deleteFriend(String username, String friendname);
	   /** @param username
	    * @pdOid f1508a13-24ab-4c03-8f4f-21a104265610 */
	   FriendList getFriendList(String username);
	   /** 用户一登陆时候
	    * 
	    * 
	    * @param username
	    * @pdOid 5b8a0473-964d-444d-96ee-64e0c02091c9 */
	   MessageSet getMessage(String username);
	   /** @param from 
	    * @param to 
	    * @param content
	    * @pdOid 0b986f37-c003-4c23-8469-71521ee0e4cf */
	   void saveMessage(String from, String to, String content);
	   /** @param keyword
	    * @pdOid 5acdcde6-5eb6-4550-9121-c8754a61e238 */
	   UserShortInfoList searchUser(String keyword);
	   /** @param username
	    * @pdOid 214b49e5-50bd-48c5-8589-6b431bf4336b */
	   Boolean checkUsername(String username);
	   /** @param userinfo
	    * @pdOid e3375e9d-4ed5-4fa9-9747-81cf3576721c */
	   void createUser(UserBaseInfo userinfo);
	   /** @param username
	    * @pdOid 3c12a4ec-96ee-418e-b012-657c8a6f3919 */
	   UserDetailInfo getDetailUserInfo(String username);
	   /** @param userinfo 
	    * @param username
	    * @pdOid 20e830a9-8b1d-4937-87af-e4859ace90b6 */
	   void updateUserInfo(UserDetailInfo userinfo, String username);

}
