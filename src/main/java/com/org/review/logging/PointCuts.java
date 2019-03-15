package com.org.review.logging;


import org.aspectj.lang.annotation.Pointcut;


public class PointCuts {
	@Pointcut("within(com.org.review.*.*)")
	public void logEntryExit() {
	}

}