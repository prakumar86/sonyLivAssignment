package com.app.sonylivappassignment;

import com.google.inject.AbstractModule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public abstract class MainModuleTest extends AbstractModule {

    @Before
    public void setup() {
    }

    @Override
    protected void configure() {

    }

    @Test
    public abstract void testDependencyBindings();
}
