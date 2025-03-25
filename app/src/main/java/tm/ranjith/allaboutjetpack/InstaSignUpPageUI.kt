package tm.ranjith.allaboutjetpack

import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tm.ranjith.allaboutjetpack.ui.theme.AllAboutJetPackTheme

class InstaSignUpPageUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AllAboutJetPackTheme {
                InstagramSignUpScreen()
            }
        }
    }
}

@Composable
fun InstagramSignUpScreen() {
    // Define Instagram colors
    val instagramBlue = Color(0xFF3897F0)
    val instagramLightGray = Color(0xFFEFEFEF)
    val instagramGray = Color(0xFF8E8E8E)
    val instagramBlack = Color(0xFF262626)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Instagram Logo
            Image(
                painter = painterResource(id = R.drawable.insta),  // Replace with your Instagram logo
                contentDescription = "Instagram Logo",
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 24.dp)
            )

            // Sign up with Facebook button
            Button(
                onClick = { /* No functionality */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = instagramBlue
                ),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_dialog_info),  // Replace with Facebook icon
                        contentDescription = "Facebook Icon",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Continue with Facebook",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // Or divider
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    color = instagramLightGray,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "OR",
                    color = instagramGray,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Divider(
                    color = instagramLightGray,
                    modifier = Modifier.weight(1f)
                )
            }

            // Phone/Email input
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Mobile Number or Email") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = instagramLightGray,
                    focusedContainerColor = instagramLightGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Full Name input
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Full Name") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = instagramLightGray,
                    focusedContainerColor = instagramLightGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Username input
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Username") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = instagramLightGray,
                    focusedContainerColor = instagramLightGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Password input
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Password") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = instagramLightGray,
                    focusedContainerColor = instagramLightGray,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp)),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Terms and Privacy Policy text
            Text(
                text = buildAnnotatedString {
                    append("People who use our service may have uploaded your contact information to Instagram. ")
                    withStyle(style = SpanStyle(color = instagramBlue)) {
                        append("Learn More")
                    }
                    append("\n\nBy signing up, you agree to our ")
                    withStyle(style = SpanStyle(color = instagramBlue)) {
                        append("Terms")
                    }
                    append(", ")
                    withStyle(style = SpanStyle(color = instagramBlue)) {
                        append("Privacy Policy")
                    }
                    append(" and ")
                    withStyle(style = SpanStyle(color = instagramBlue)) {
                        append("Cookies Policy")
                    }
                    append(".")
                },
                color = instagramGray,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Sign up button
            Button(
                onClick = { /* No functionality */ },
                colors = ButtonDefaults.buttonColors(containerColor = instagramBlue),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                enabled = false // Disabled initially (as Instagram does)
            ) {
                Text(
                    text = "Sign up",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            // Sign up for now
            Spacer(modifier = Modifier.weight(1f))

            // Bottom "Log in" link
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .border(
                        width = 1.dp,
                        color = instagramLightGray,
                        shape = RoundedCornerShape(0.dp)
                    )
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Have an account? ",
                    color = instagramBlack
                )
                Text(
                    text = "Log in",
                    color = instagramBlue,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { /* No functionality */ }
                )
            }
        }
    }
}

// Optional: Language selector at the bottom
@Composable
fun LanguageSelector() {
    val selectedLanguage = remember { mutableStateOf("English (United States)") }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(
            text = selectedLanguage.value,
            color = Color(0xFF8E8E8E),
            fontSize = 12.sp
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Select Language",
            tint = Color(0xFF8E8E8E),
            modifier = Modifier.size(16.dp)
        )
    }
}