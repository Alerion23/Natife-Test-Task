package com.wenger.natifetesttask.utils

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

inline fun <T> Flow<T>.collectWhenStarted(
    lifecycleScope: LifecycleCoroutineScope,
    crossinline body: (T) -> Unit
): Job = lifecycleScope.launchWhenStarted { collectLatest { body(it) } }
