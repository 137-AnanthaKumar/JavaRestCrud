package com.example.restapi.twiliosms;

public interface SmsSender {
	void sendSms(String phoneNo, String messege);
}
