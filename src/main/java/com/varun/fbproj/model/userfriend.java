package com.varun.fbproj.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class userfriend {

	    private int userID;
		private int friendID;
		private int statusID;
		private int initiatorID;
		private int receiverID;
		private String user_token;
		
		public userfriend()
		{
			
		}


		public userfriend(int userID,int friendID, int statusID, int initiatorID,int receiverID
				) {
			super();
			this.userID=userID;
			this.friendID = friendID;
			this.statusID=statusID;
			this.initiatorID=initiatorID;
			this.receiverID=receiverID;
		}

		@JsonProperty(value = "userID")
		public int getUserID() {
			return userID;
		}


		public void setUserID(int userID) {
			this.userID = userID;
		}

		@JsonProperty(value = "statusID")
		public int getstatusID() {
			return statusID;
		}


		public void setinitiatorID(int initiatorID) {
			this.initiatorID = initiatorID;
		}
		@JsonProperty(value = "initiatorID")
		public int getinitiatorID() {
			return initiatorID;
		}
		public void setreceiverID(int receiverID) {
			this.receiverID = receiverID;
		}
		@JsonProperty(value = "receiverID")
		public int getreceiverID() {
			return receiverID;
		}


		public void setstatusID(int statusID) {
			this.statusID = statusID;
		}

		@JsonProperty(value = "friendID")
		public int getfriendID() {
			return friendID;
		}


		public void setfriendID(int friendID) {
			this.friendID =friendID;
		}
		

	
}//class ends here

