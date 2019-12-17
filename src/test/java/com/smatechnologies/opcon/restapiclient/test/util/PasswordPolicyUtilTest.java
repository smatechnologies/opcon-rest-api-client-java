package com.smatechnologies.opcon.restapiclient.test.util;

import com.smatechnologies.opcon.restapiclient.model.ServerOptions;
import com.smatechnologies.opcon.restapiclient.util.PasswordPolicyUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;


/**
 * @author Pierre PINON
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PasswordPolicyUtilTest {

    private ServerOptions.PasswordPolicy passwordPolicy;

    @Before
    public void before() {
        passwordPolicy = new ServerOptions.PasswordPolicy();
    }

    @Test(expected = NullPointerException.class)
    public void test01nullLoginName() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate(null, "", passwordPolicy);
    }

    @Test(expected = NullPointerException.class)
    public void test02nullPassword() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate("", null, passwordPolicy);
    }

    @Test(expected = NullPointerException.class)
    public void test03nullPolicy() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate("", "", null);
    }

    @Test
    public void test04equals() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("", "ocadm", passwordPolicy);

        try {
            PasswordPolicyUtil.validate("", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_EQUALS), e.getCodes());
        }

        try {
            PasswordPolicyUtil.validate("ocadm", "ocadm", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_EQUALS), e.getCodes());
        }
    }

    @Test
    public void test05charsMin() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "a", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "ab", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);

        passwordPolicy.setMinimumCharacters(0);
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "a", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "ab", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);

        passwordPolicy.setMinimumCharacters(1);
        try {
            PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        PasswordPolicyUtil.validate("ocadm", "a", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "ab", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);

        passwordPolicy.setMinimumCharacters(2);
        try {
            PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "a", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        PasswordPolicyUtil.validate("ocadm", "ab", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);

        passwordPolicy.setMinimumCharacters(3);
        try {
            PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "a", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "ab", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);

        passwordPolicy.setMinimumCharacters(4);
        try {
            PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "a", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "ab", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_MIN), e.getCodes());
        }
    }

    @Test
    public void test06charsRepeat() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "test", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "tesst", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "tessst", passwordPolicy);

        passwordPolicy.setRepeatedCharacterOccurrencesAllowed(0);
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "test", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "tesst", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "tessst", passwordPolicy);

        passwordPolicy.setRepeatedCharacterOccurrencesAllowed(1);
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "test", passwordPolicy);
        try {
            PasswordPolicyUtil.validate("ocadm", "tesst", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REPEAT), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "tessst", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REPEAT), e.getCodes());
        }

        passwordPolicy.setRepeatedCharacterOccurrencesAllowed(2);
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "test", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "tesst", passwordPolicy);
        try {
            PasswordPolicyUtil.validate("ocadm", "tessst", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REPEAT), e.getCodes());
        }

        passwordPolicy.setRepeatedCharacterOccurrencesAllowed(3);
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "test", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "tesst", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "tessst", passwordPolicy);
    }

    @Test
    public void test07charsAlpha() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);

        passwordPolicy.setAlphaRequired(false);
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);

        passwordPolicy.setAlphaRequired(true);
        try {
            PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_ALPHA), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_ALPHA), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_ALPHA), e.getCodes());
        }
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
    }

    @Test
    public void test08charsNumeric() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);

        passwordPolicy.setNumericRequired(false);
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);

        passwordPolicy.setNumericRequired(true);
        try {
            PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_NUMERIC), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_NUMERIC), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_NUMERIC), e.getCodes());
        }
        PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);
    }

    @Test
    public void test09charsSpecial() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);

        passwordPolicy.setSpecialCharacterRequired(false);
        PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);
        PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);

        passwordPolicy.setSpecialCharacterRequired(true);
        try {
            PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_SPECIAL), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_SPECIAL), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_SPECIAL), e.getCodes());
        }
        PasswordPolicyUtil.validate("ocadm", "*/=", passwordPolicy);
    }

    @Test
    public void test10multi() throws PasswordPolicyUtil.PasswordPolicyUtilException {
        passwordPolicy.setAlphaRequired(true);
        passwordPolicy.setNumericRequired(true);

        try {
            PasswordPolicyUtil.validate("ocadm", "", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_ALPHA, PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_NUMERIC), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "abc", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_NUMERIC), e.getCodes());
        }
        try {
            PasswordPolicyUtil.validate("ocadm", "123", passwordPolicy);
            Assert.fail("Should throw an exception");
        } catch (PasswordPolicyUtil.PasswordPolicyUtilException e) {
            Assert.assertEquals(Arrays.asList(PasswordPolicyUtil.PasswordPolicyUtilException.ERROR_CHARS_REQUIRED_ALPHA), e.getCodes());
        }
        PasswordPolicyUtil.validate("ocadm", "abc123", passwordPolicy);
    }
}
