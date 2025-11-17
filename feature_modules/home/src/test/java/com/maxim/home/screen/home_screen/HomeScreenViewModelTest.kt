package com.maxim.home.screen.home_screen

import app.cash.turbine.test
import com.maxim.common.util.NoopLog
import com.maxim.domain.use_case.get_all_jogs.GetAllJogsUseCase
import com.maxim.testing.data.testJogs
import com.maxim.testing.rules.MainDispatcherRule
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeScreenViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var getAllJogsUseCase: GetAllJogsUseCase
    private lateinit var viewModel: HomeScreenViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        getAllJogsUseCase = mockk()
    }

    @Test
    fun `uiState should start with Loading`() = runTest {
        every { getAllJogsUseCase() } returns flowOf(emptyList())
        viewModel = HomeScreenViewModel(getAllJogsUseCase, NoopLog)

        viewModel.uiState.test {
            assertEquals(HomeScreenUiState.Loading, awaitItem())
        }
    }

    @Test
    fun `uiState should be Success when useCase return list of jogs`() = runTest {
        every { getAllJogsUseCase() } returns flowOf(testJogs)
        viewModel = HomeScreenViewModel(getAllJogsUseCase, NoopLog)

        viewModel.uiState.test {
            assertEquals(HomeScreenUiState.Loading, awaitItem())
            val success = awaitItem()
            assertTrue(success is HomeScreenUiState.Success)
        }
    }

    @Test
    fun `viewModel should emit same jogList as useCase emits`() = runTest {
        every { getAllJogsUseCase() } returns flowOf(testJogs)
        viewModel = HomeScreenViewModel(getAllJogsUseCase, NoopLog)

        viewModel.uiState.test {
            skipItems(1)
            assertEquals(testJogs, (awaitItem() as HomeScreenUiState.Success).jogList)
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `uiState should be Error when useCase return error`() = runTest {
        every { getAllJogsUseCase() } returns flow {
            emit(emptyList())
            throw RuntimeException()
        }
        viewModel = HomeScreenViewModel(getAllJogsUseCase, NoopLog)

        viewModel.uiState.test {
            skipItems(2)
            val error = awaitItem()
            assertTrue(error is HomeScreenUiState.Error)
            cancelAndIgnoreRemainingEvents()
        }
    }
}