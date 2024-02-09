package utils;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static utils.WebDriverThreadLocal.quitDriver;

public class WebDriverExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {


    @Override
    public void beforeAll(ExtensionContext context) {
    }

    @Override
    public void afterAll(ExtensionContext context) {
        quitDriver();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
    }

    @Override
    public void afterEach(ExtensionContext context) {
        quitDriver();
    }
}
