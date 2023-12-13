/*
 * Copyright 2023 Arman Bilge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package meep

trait Applicative[F[_]] extends Functor[F] {

  extension [A](a: A) {
    def pure: F[A]
  }

  extension [A, B](fab: F[A => B]) {
    def ap(fa: F[A]): F[B]
  }

  def unit: F[Unit] = ().pure

}

object Applicative extends ApplicativeCompanion

trait ApplicativeCompanion {
  inline def unit[F[_]](using F: Applicative[F]): F[Unit] = F.unit
}
