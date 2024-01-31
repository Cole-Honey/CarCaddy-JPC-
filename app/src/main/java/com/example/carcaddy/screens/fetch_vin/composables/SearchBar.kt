package com.example.carcaddy.screens.fetch_vin.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    searchTerm1: MutableState<String>,
//    searchTerm2: MutableState<String>,
    searchFun: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = searchTerm1.value,
        onValueChange = {
            searchTerm1.value = it
        },
        singleLine = true,
        label = { Text("Enter VIN") },
        leadingIcon = {
            FetchButton(
                onClickLambda = {
                    if (searchTerm1.value.isNotEmpty()) {
                        searchFun(searchTerm1.value)
                        focusManager.clearFocus()
                    }
                },
                image = Icons.Outlined.Search,
                desc = "Search"
            )
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                searchFun(searchTerm1.value)
                focusManager.clearFocus()
            },
            onDone = {
                focusManager.clearFocus()
            }
        ),
        shape = RoundedCornerShape(25.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .focusRequester(focusRequester)
    )

//    OutlinedTextField(
//        value = searchTerm2.value,
//        onValueChange = {
//            searchTerm2.value = it
//        },
//        singleLine = true,
//        label = { Text("Enter Year") },
//        leadingIcon = {
//            FetchButton(
//                onClickLambda = {
//                    if (searchTerm2.value.isNotEmpty()) {
//                        searchFun(searchTerm1.value)
//                        focusManager.clearFocus()
//                    }
//                },
//                image = Icons.Outlined.Search,
//                desc = "Search"
//            )
//        },
//        keyboardOptions = KeyboardOptions(
//            imeAction = ImeAction.Search
//        ),
//        keyboardActions = KeyboardActions(
//            onSearch = {
//                searchFun(searchTerm1.value)
//                focusManager.clearFocus()
//            },
//            onDone = {
//                focusManager.clearFocus()
//            }
//        ),
//        shape = RoundedCornerShape(25.dp),
//        colors = TextFieldDefaults.colors(
//            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
//            unfocusedIndicatorColor = MaterialTheme.colorScheme.primary,
//        ),
//        modifier = modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp)
//            .focusRequester(focusRequester)
//    )
}