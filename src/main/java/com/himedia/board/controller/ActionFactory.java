package com.himedia.board.controller;

import com.himedia.board.controller.action.Action;
import com.himedia.board.controller.action.board.MainAction;
import com.himedia.board.controller.action.member.IdcheckAction;
import com.himedia.board.controller.action.member.JoinAction;
import com.himedia.board.controller.action.member.JoinFormAction;
import com.himedia.board.controller.action.member.LoginAction;
import com.himedia.board.controller.action.member.LoginFormAction;
import com.himedia.board.controller.action.member.LogoutAction;

public class ActionFactory {

	// 싱글톤 클래스
	private ActionFactory() {
	}

	private static ActionFactory itc = new ActionFactory();

	public static ActionFactory getInstance() {
		return itc;
	}
	// command 값에 따라 해당 클래스와 인스턴스를 Action 참조변수에 조립하는 역할
	public Action getAction(String command) {
		Action ac = null;
	
		if(command.equals("loginForm")) ac  = new LoginFormAction();
		else if(command.equals("login")) ac = new LoginAction();
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idcheck")) ac = new IdcheckAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("main")) ac = new MainAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		return ac;
	}
}
