package com.na2te.restore

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.na2te.restore.ui.theme.RestoreTheme
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "Activity 생명주기"
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        var cnt by mutableIntStateOf(0)
        Log.d(TAG, "onCreate: Create 호출 $cnt")
        ViewModelProvider(this)
        setContent {
            RestoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        ActivityScreen(
                            modifier = Modifier.padding(innerPadding),
                            cnt = cnt,
                            onClickIncrement = { cnt++ }
                        )
                        Restore(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: Destroy 호출")
        super.onDestroy()
    }
}

