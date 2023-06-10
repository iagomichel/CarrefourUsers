package com.iagomichel.carrefourusers.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.iagomichel.carrefourusers.data.model.Users
import com.iagomichel.carrefourusers.data.service.UsersApi
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(JUnit4::class)
class UserRepositoryImplTest : KoinComponent {

    private val userRepository: UserRepository by inject()

    private val dispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val usersApi: UsersApi = mockk()

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)

        // Verificar se o Koin já foi iniciado
        if (!isKoinAlreadyStarted()) {
            startKoin {
                loadKoinModules(
                    module {
                        single<UserRepository> { UserRepositoryImpl(usersApi) }
                    }
                )
            }
        }
    }

    private fun isKoinAlreadyStarted() =
        GlobalContext.getOrNull() !== null

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test fetchRemoteDataUsers should return list of users`() {
        runTest {
            // Given
            val usersList: List<Users> = mockk()
            coEvery { usersApi.fetchUsers() } returns usersList

            // When
            val result = userRepository.fetchRemoteDataUsers()

            // Then
            assertEquals(usersList, result)
        }
    }
}
