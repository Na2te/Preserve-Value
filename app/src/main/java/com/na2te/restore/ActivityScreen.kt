package com.na2te.restore

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.na2te.restore.ui.theme.RestoreTheme

@Composable
fun ActivityScreen(modifier: Modifier = Modifier, cnt: Int, onClickIncrement: () -> Unit, restoreViewModel: RestoreViewModel = viewModel()) {
    Column(modifier = modifier){
        Text("Activity Total Cnt : $cnt")
        Button(
            modifier = modifier,
            onClick = onClickIncrement
        ) {
            Text("Cnt ++ Button")
        }
    }
}

@Preview
@Composable
fun ActivityScreenPreview() {
    RestoreTheme {
        ActivityScreen(cnt = 0, onClickIncrement = {})
    }
}
