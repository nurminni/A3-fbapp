package com.arcada.devops.niklas.facebookapp;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FacebookFriendsAppTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
    public void testGetFriendList_PositiveScenario() {
        FacebookFriendsApp app = new FacebookFriendsApp();
        String[] friendList = app.getFriendList("https://www.facebook.com/someuser");
        assertNotNull(friendList);
        assertEquals(3, friendList.length);
        assertArrayEquals(new String[]{"Niklas", "William", "Niraj", "Kim"}, friendList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFriendList_NullInput() {
        FacebookFriendsApp app = new FacebookFriendsApp();
        app.getFriendList(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFriendList_InvalidFacebookLink() {
        FacebookFriendsApp app = new FacebookFriendsApp();
        app.getFriendList("invalid-link");
    }

    // Performance test (example)
    @Test(timeout = 1000)
    public void testGetFriendList_Performance() {
        FacebookFriendsApp app = new FacebookFriendsApp();
        app.getFriendList("https://www.facebook.com/someuser");
    }

}
