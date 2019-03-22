package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PacManTest {

	@Test
	void test() {
		setupScenary1();
	}
	public void setupScenary1() {
		PacMan test = new PacMan(20, 10, 30, 2, 10); 
		assertNotNull(test);
		
	}

}
