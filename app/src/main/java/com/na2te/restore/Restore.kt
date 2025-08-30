package com.na2te.restore

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

private const val  TAG = "Recomposition"
@Composable
fun Restore(modifier: Modifier = Modifier, restoreViewModel: RestoreViewModel = hiltViewModel()) {
    var parentCnt by mutableIntStateOf(0)
    Log.d(TAG, "Restore REComposition: 초기화 $parentCnt")
    var rememberCnt by remember { mutableIntStateOf(0) }
    var rememberSavableCnt by rememberSaveable { mutableIntStateOf(0) }
    val viewModelCnt by restoreViewModel.memoryCount.collectAsStateWithLifecycle()
    val stateHandleCnt by restoreViewModel.savedStateCount.collectAsStateWithLifecycle()

    Restore(modifier, parentCnt, rememberCnt, rememberSavableCnt, viewModelCnt, stateHandleCnt) {

        parentCnt++;
        Log.d(TAG, "Restore 클릭 이벤트 발생: $parentCnt")
        rememberCnt++; rememberSavableCnt++; restoreViewModel.increment()
    }

}

@Composable
private fun Restore(modifier: Modifier = Modifier, cnt: Int, rememberCnt: Int, rememberSavableCnt: Int, viewModelCnt: Int, stateHandleCnt: Int, onClickIncrement: () -> Unit) {

    Column(modifier = modifier) {
        Text(
            text = "No Remember TotalCnt $cnt!",
        )
        Text(
            text = "RememberMemoryTotalCnt $rememberCnt!",
        )
        Text(
            text = "RememberSavableMemoryTotalCnt $rememberSavableCnt!",
        )
        Text(
            text = "ViewModelTotalCnt $viewModelCnt!",
        )
        Text(
            text = "SavedStateHandleTotalCnt $stateHandleCnt!",
        )
        Button(onClick = onClickIncrement) {
            Text("Cnt ++ Button")
        }
    }
}

@Preview
@Composable
fun RestorePreview() {
    Restore(
        modifier = Modifier,
        cnt = 0,
        rememberCnt = 0,
        rememberSavableCnt = 0,
        viewModelCnt = 0,
        stateHandleCnt = 0,
        onClickIncrement = {}
    )
}

