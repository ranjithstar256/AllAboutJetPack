package tm.ranjith.allaboutjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tm.ranjith.allaboutjetpack.ui.theme.AllAboutJetPackTheme

class ComposeBasicFunctionality : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AllAboutJetPackTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Our main composable function with basic functionality examples
                    //ComposeBasicFunctionality()
                    StartPage()
                }
            }
        }
    }


     @Composable
    fun ComposeBasicFunctionality() {
        // This is a scrollable column that will contain all our examples
        Column(
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Compose Basic Functionality",
                style = MaterialTheme.typography.headlineMedium
            )

            HorizontalDivider()

            // EXAMPLE 1: Basic State Management
            Text(
                text = "Example 1: State Management",
                style = MaterialTheme.typography.titleLarge
            )

            // Remember creates a state that survives recompositions
            var counter by remember { mutableStateOf(0) }

            // Display current state value
            Text(text = "Counter value: $counter")

            // Buttons to modify state
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { counter-- }) {
                    Text("-")
                }

                Button(onClick = { counter++ }) {
                    Text("+")
                }
            }

            HorizontalDivider()

            // EXAMPLE 2: Text Input and Display
            Text(
                text = "Example 2: Text Input and Display",
                style = MaterialTheme.typography.titleLarge
            )

            // State for storing user input
            var userInput by remember { mutableStateOf("") }

            //  Text field for user input
            OutlinedTextField(
                value = userInput,
                onValueChange = { userInput = it },
                label = { Text("Enter some text") },
                modifier = Modifier.fillMaxWidth()
            )
            //  LanguageSelector()
            // Display what the user has typed
            Text(
                text = "You typed: $userInput",
                style = MaterialTheme.typography.bodyLarge
            )

            HorizontalDivider()

            // EXAMPLE 3: Form with Validation
            Text(
                text = "Example 3: Form Validation",
                style = MaterialTheme.typography.titleLarge
            )

            // State variables for form fields
            var username by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            // State variables for validation errors
            var usernameError by remember { mutableStateOf("") }
            var passwordError by remember { mutableStateOf("") }

            // Function to validate form
            fun validateForm(): Boolean {
                var isValid = true

                // Username validation
                if (username.isEmpty()) {
                    usernameError = "Username cannot be empty"
                    isValid = false
                } else if (username.length < 4) {
                    usernameError = "Username must be at least 4 characters"
                    isValid = false
                } else {
                    usernameError = ""
                }

                // Password validation
                if (password.isEmpty()) {
                    passwordError = "Password cannot be empty"
                    isValid = false
                } else if (password.length < 6) {
                    passwordError = "Password must be at least 6 characters"
                    isValid = false
                } else {
                    passwordError = ""
                }

                return isValid
            }

            // Username field
            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                    // Clear error when user types
                    if (usernameError.isNotEmpty()) {
                        usernameError = ""
                    }
                },
                label = { Text("Username") },
                isError = usernameError.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            )

            // Show error message if any
            if (usernameError.isNotEmpty()) {
                Text(
                    text = usernameError,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    // Clear error when user types
                    if (passwordError.isNotEmpty()) {
                        passwordError = ""
                    }
                },
                label = { Text("Password") },
                isError = passwordError.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            )

            // Show error message if any
            if (passwordError.isNotEmpty()) {
                Text(
                    text = passwordError,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Submit button with form validation
            var formSubmitted by remember { mutableStateOf(false) }

            Button(
                onClick = {
                    if (validateForm()) {
                        formSubmitted = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }

            // Show success message when form is successfully submitted
            if (formSubmitted) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF4CAF50).copy(alpha = 0.1f)
                    )
                ) {
                    Text(
                        text = "Form submitted successfully!",
                        color = Color(0xFF4CAF50),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            HorizontalDivider()

            // EXAMPLE 4: Derived State
            Text(
                text = "Example 4: Derived State",
                style = MaterialTheme.typography.titleLarge
            )

            // Two independent state variables
            var firstName by remember { mutableStateOf("") }
            var lastName by remember { mutableStateOf("") }

            // Derived state that combines the two inputs
            // It automatically updates when either input changes
            val fullName by remember(firstName, lastName) {
                derivedStateOf {
                    if (firstName.isNotEmpty() || lastName.isNotEmpty()) {
                        "$firstName $lastName".trim()
                    } else {
                        "Please enter your name"
                    }
                }
            }

            // Input fields
            OutlinedTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = { Text("First Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = { Text("Last Name") },
                modifier = Modifier.fillMaxWidth()
            )

            // Display derived state
            Text(
                text = "Full name: $fullName",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            HorizontalDivider()

            // EXAMPLE 5: Toggle Visibility
            Text(
                text = "Example 5: Conditional UI",
                style = MaterialTheme.typography.titleLarge
            )

            // State for controlling visibility
            var showDetails by remember { mutableStateOf(false) }

            // Button to toggle visibility
            Button(
                onClick = { showDetails = !showDetails },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (showDetails) "Hide Details" else "Show Details")
            }

            // Conditional UI element
            if (showDetails) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Additional Details",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "This section is only visible when the button is toggled on. " +
                                    "In Compose, you can easily show or hide UI elements based on state."
                        )
                    }
                }
            }

            // Extra space at the bottom
            Spacer(modifier = Modifier.height(32.dp))
        }



    }



    @Composable
    fun StartPage() {

        val navController = rememberNavController()


        NavHost(
            navController = navController,
            startDestination ="startpage"
        ) {
            composable("startpage"){
                starthere(navController)
            }
            composable("signup"){
                SignupPage(navController)
            }
            composable("signin/{x}/{y}"){
                backStackEntry ->
                val valone = backStackEntry.arguments?.getString("x")
                val valtwo = backStackEntry.arguments?.getString("y")


                SignInPage(navController,valone,valtwo)
            }
        }


    }


    @Composable
    fun starthere(navController: NavHostController){
        Column(
            modifier = Modifier
                .fillMaxSize().background(Color.Magenta)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to the Start Page!",
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate("signup")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("go to sign up page")
            }
        }
    }


    @Composable
    fun SignupPage(navController: NavHostController) {
        Column(
            modifier = Modifier
                .fillMaxSize().background(Color.Yellow)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to the \n Signup Page!",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("signin/jaison/kerala")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("go to sign in page")
            }
        }
    }


    @Composable
    fun SignInPage(navController: NavHostController, valone: String?, valtwo: String?) {
        Column (modifier = Modifier
            .fillMaxSize().background(Color.Blue)
            .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Sign In Page $valone $valtwo", color = Color.White, fontSize = 32.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    navController.navigate("startpage")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("go to start page")
            }
        }
    }


}