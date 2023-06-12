package com.iagomichel.carrefourusers.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasChildCount
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.iagomichel.carrefourusers.viewmodel.UsersViewModel
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.iagomichel.carrefourusers.R
import com.iagomichel.carrefourusers.data.repository.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

@RunWith(AndroidJUnit4::class)
class UsersFragmentTest : KoinComponent{
    private lateinit var usersViewModel: UsersViewModel
    private val userRepository: UserRepository by inject()

    private lateinit var fragmentScenario: FragmentScenario<UsersFragment>
    private lateinit var fragment: UsersFragment

    @Before
    fun setup() {
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

        fragmentScenario = launchFragmentInContainer()
        fragmentScenario.onFragment { fragment ->
            this.fragment = fragment
        }
    }

    private fun isKoinAlreadyStarted() =
        GlobalContext.getOrNull() !== null

    @Test
    fun testLoadingVisibility() {
        usersViewModel.fetchUsersList()

        onView(withId(R.id.progress_loading)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_users)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)))
    }

    @Test
    fun testusersListUpdated() {
        onView(withId(R.id.recycler_users))
            .check(matches(
                hasChildCount(
                    usersViewModel.users.value?.size ?: 0
                )
            ))
    }
}
