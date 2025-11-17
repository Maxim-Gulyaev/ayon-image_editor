package com.maxim.run.run_screen

import com.maxim.domain.use_case.save_jog.SaveJogUseCase
import com.maxim.testing.rules.MainDispatcherRule
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds

class RunViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: RunViewModel
    private lateinit var saveJogUseCase: SaveJogUseCase

    @Before
    fun setup() {
        saveJogUseCase = mockk()
    }

    @Test
    fun `jogDuration should be zero when viewModel starts`() {
        viewModel = RunViewModel(saveJogUseCase)

        assertEquals(0.seconds, viewModel.uiState.value.jogDuration)
    }

    @Test
    fun `isStopwatchRunning is true when initial OnStartClick`() {
        viewModel = RunViewModel(saveJogUseCase)
        val intent = RunScreenIntent.OnStartClick

        viewModel.accept(intent)

        assertTrue(viewModel.uiState.value.isStopwatchRunning)
    }

    @Test
    fun `isStopwatchRunning is false when second OnStartClick`() {
        viewModel = RunViewModel(saveJogUseCase)
        val intent = RunScreenIntent.OnStartClick

        viewModel.accept(intent)
        viewModel.accept(intent)

        assertFalse(viewModel.uiState.value.isStopwatchRunning)
    }

    @Test
    fun `jogDuration is zero when OnResetClick`() {
        viewModel = RunViewModel(saveJogUseCase)
        viewModel.setUiStateForTest(RunUiState(20.minutes, true))
        val intent = RunScreenIntent.OnResetClick

        viewModel.accept(intent)

        assertEquals(0.seconds, viewModel.uiState.value.jogDuration)
    }

    @Test
    fun `isStopwatchRunning is false when OnResetClick`() {
        viewModel = RunViewModel(saveJogUseCase)
        viewModel.setUiStateForTest(RunUiState(20.minutes, true))
        val intent = RunScreenIntent.OnResetClick

        viewModel.accept(intent)

        assertFalse(viewModel.uiState.value.isStopwatchRunning)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `jogDuration value encreases when isStopwatchRunning is true`() = runTest {
        viewModel = RunViewModel(saveJogUseCase)
        val intent = RunScreenIntent.OnStartClick

        viewModel.accept(intent)
        advanceTimeBy(11_000)
        viewModel.accept(intent)

        assertEquals(10.seconds, viewModel.uiState.value.jogDuration)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `OnSaveClick should call saveJogUseCase with current jogDuration`() = runTest {
        val saveJogUseCase: SaveJogUseCase = mockk(relaxed = true)
        viewModel = RunViewModel(saveJogUseCase)
        viewModel.setUiStateForTest(RunUiState(10.seconds, false))
        val intent = RunScreenIntent.OnSaveClick

        viewModel.accept(intent)
        advanceUntilIdle()

        coVerify(exactly = 1) {
            saveJogUseCase(10.seconds)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `OnSaveClick blocked when isStopwatchRunning is true`() = runTest {
        val saveJogUseCase: SaveJogUseCase = mockk(relaxed = true)
        viewModel = RunViewModel(saveJogUseCase)
        viewModel.setUiStateForTest(RunUiState(10.seconds, true))
        val intent = RunScreenIntent.OnSaveClick

        viewModel.accept(intent)
        advanceUntilIdle()

        coVerify(exactly = 0) {
            saveJogUseCase(10.seconds)
        }
    }


}