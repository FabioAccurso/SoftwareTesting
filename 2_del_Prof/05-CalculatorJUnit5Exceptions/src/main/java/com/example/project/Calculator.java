/*
 * Copyright 2015-2024 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}
	
	public float division (int a, int b) throws Exception {
		if (b == 0)
	       { throw new Exception ("Divisione per zero");  }
		return (float)a/ (float)b;
	}

public double radice (int x) {
	return Math.sqrt(x);
}

}
