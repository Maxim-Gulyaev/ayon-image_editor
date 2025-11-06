package com.maxim.home

import com.maxim.domain.use_case.get_all_jogs.GetAllJogsUseCase
import com.maxim.home.screen.home_screen.HomeScreenUiState
import com.maxim.home.screen.home_screen.HomeScreenViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeScreenViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var getAllJogsUseCase: GetAllJogsUseCase
    private lateinit var viewModel: HomeScreenViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        getAllJogsUseCase = mockk()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `uiState should start with Loading`() = runTest {
        every { getAllJogsUseCase() } returns flowOf(emptyList())

        viewModel = HomeScreenViewModel(getAllJogsUseCase)

        assertEquals(HomeScreenUiState.Loading, viewModel.uiState.value)
    }
}