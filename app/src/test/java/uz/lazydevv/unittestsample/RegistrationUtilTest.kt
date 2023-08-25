package uz.lazydevv.unittestsample

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username, returns false`() {
        val result = RegistrationUtil.validateRegistration(
            username = "",
            password = "12345678",
            confirmedPassword = "12345678"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `empty password, returns false`() {
        val result = RegistrationUtil.validateRegistration(
            username = "name",
            password = "",
            confirmedPassword = ""
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `username already exists, returns false`() {
        val result = RegistrationUtil.validateRegistration(
            username = "Botir",
            password = "12345678",
            confirmedPassword = "12345678"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `incorrectly confirmed password, returns false`() {
        val result = RegistrationUtil.validateRegistration(
            username = "name",
            password = "12345678",
            confirmedPassword = "qwertyui"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `less than 8 length password, returns false`() {
        val result = RegistrationUtil.validateRegistration(
            username = "name",
            password = "1234",
            confirmedPassword = "1234"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `less than 2 digit password, returns false`() {
        val result = RegistrationUtil.validateRegistration(
            username = "name",
            password = "qwertyu3",
            confirmedPassword = "qwertyu3"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `valid inputs, returns true`() {
        val result = RegistrationUtil.validateRegistration(
            username = "name",
            password = "12345678",
            confirmedPassword = "12345678"
        )

        assertThat(result).isTrue()
    }
}