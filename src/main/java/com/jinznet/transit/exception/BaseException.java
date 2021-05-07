/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 */
package com.jinznet.transit.exception;

/**
 * @author hejian
 * 
 */
public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4551687012746638492L;

	/**
	 * 
	 */
	public BaseException() {
		super();
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable throwable) {
		super(throwable);
	}

	public BaseException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
