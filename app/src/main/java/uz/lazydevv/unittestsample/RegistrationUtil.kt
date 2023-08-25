package uz.lazydevv.unittestsample

object RegistrationUtil {

    private val existingUsers = listOf("Botir", "Jahongir", "Akbarali")

    /**
     * the input is not valid if...
     * ...the username/password is empty
     * ...the username is already taken
     * ...the confirmed password is not the same as the real password
     * ...the password length less than 8 characters
     * ...the password contains less than 2 digits
     */
    fun validateRegistration(
        username: String,
        password: String,
        confirmedPassword: String
    ): Boolean {
        return when {
            username.isEmpty() || password.isEmpty() -> false

            username in existingUsers -> false

            password != confirmedPassword -> false

            password.length < 8 -> false

            password.count { it.isDigit() } < 2 -> false

            else -> true
        }
    }
}