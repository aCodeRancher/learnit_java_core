package com.itbulls.learnit.javacore.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AccountTest {

    @Mock
    private Account expectedAccount;

    @Mock(answer= Answers.RETURNS_DEEP_STUBS)
    private Account.Builder builder;

    @Test
    public void deepStubTest(){
        Mockito.when(builder.setToken("12345").setUserId("9876").build()).thenReturn(expectedAccount);
        assertEquals(expectedAccount,builder.setToken("12345").setUserId("9876").build());
    }
}
