package com.iagomichel.carrefourusers.viewmodel

import androidx.lifecycle.Observer
import com.iagomichel.carrefourusers.data.model.Users
import com.iagomichel.carrefourusers.data.repository.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module
import androidx.arch.core.*
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.rules.TestRule
import org.koin.core.context.GlobalContext

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class UsersViewModelTest : KoinComponent {

    private lateinit var usersViewModel: UsersViewModel
    private val userRepository: UserRepository by inject()

    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun before() {
        Dispatchers.setMain(dispatcher)

        // Verificar se o Koin já foi iniciado
        if (!isKoinAlreadyStarted()) {
            startKoin {
                loadKoinModules(
                    module {
                        single<UserRepository> { mockk() }
                    }
                )
            }
        }
        usersViewModel = UsersViewModel(userRepository)
    }

    private fun isKoinAlreadyStarted() =
        GlobalContext.getOrNull() !== null

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test fetchUsersList should update users LiveData`() {
        // Given
        val usersList: List<Users> = mockk()
        coEvery { userRepository.fetchRemoteDataUsers() } returns usersList

        val usersObserver = mockk<Observer<List<Users>>>(relaxed = true)
        usersViewModel.users.observeForever(usersObserver)

        // When
        usersViewModel.fetchUsersList()

        // Then
        coVerify { userRepository.fetchRemoteDataUsers() }
        verify { usersObserver.onChanged(usersList) }
    }

    @Test
    fun `test fetchUsersList should update loading LiveData`() {
        // Given
        val usersList: List<Users> = mockk()
        coEvery { userRepository.fetchRemoteDataUsers() } returns usersList

        val loadingObserver = mockk<Observer<Boolean>>(relaxed = true)
        usersViewModel.loading.observeForever(loadingObserver)

        // When
        usersViewModel.fetchUsersList()

        // Then
        verify { loadingObserver.onChanged(true) }
        verify { loadingObserver.onChanged(false) }
    }

    @Test
    fun `test fetchUsersList should update error LiveData when there is an exception`() {
        // Given
        val errorMessage = "Error fetching users"
        coEvery { userRepository.fetchRemoteDataUsers() } throws RuntimeException(errorMessage)

        val errorObserver = mockk<Observer<String>>(relaxed = true)
        usersViewModel.error.observeForever(errorObserver)

        // When
        usersViewModel.fetchUsersList()

        // Then
        verify { errorObserver.onChanged(errorMessage) }
    }
}
