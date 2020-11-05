#include <GL/glew.h>
#include <GLFW/glfw3.h>

#include <fstream>
#include <iostream>
#include <sstream>
#include <string>

#include "IndexBuffer.h"
#include "Renderer.h";
#include "Shader.h"
#include "Texture.h"
#include "VertexArray.h"
#include "VertexBuffer.h"
#include "VertexBufferLayout.h"
#include "glm/glm.hpp";
#include "glm/gtc/matrix_transform.hpp"
#include "imgui/imgui.h"
#include "imgui/imgui_impl_glfw_gl3.h"

int main() {
  if (!glfwInit()) {
    return -1;
  }

  glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
  glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 5);
  glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

  GLFWwindow* window = glfwCreateWindow(1024, 768, "OpenGL", NULL, NULL);

  if (!window) {
    glfwTerminate();
    return -1;
  }

  glfwMakeContextCurrent(window);
  glfwSwapInterval(1);

  if (glewInit() == GLEW_OK) {
    std::cout << "Successfully initialized GLEW\n";
  }

  float positions[] = {
      0.0f, 0.0f, 0.0f, 0.0f,
      100.0f, 0.0f, 1.0f, 0.0f,
      100.0f, 100.0f, 1.0f, 1.0f,
      0.0f, 100.0f, 0.0f, 1.0f
  };

  // Using Index buffer to keep GPU memory as low as possible, by prohibiting
  // ourself to no to copy same data again and again, just supply only unique
  // data points (Vertices)
  unsigned int indices[] = {0, 1, 2, 2, 3, 0};

  GLCall(glEnable(GL_BLEND));
  GLCall(glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA));

  VertexArray va;
  VertexBuffer vb(positions, 4 * 4 * sizeof(float));
  VertexBufferLayout layout;
  layout.Push<float>(2);
  layout.Push<float>(2);
  va.AddBuffer(vb, layout);

  IndexBuffer ib(indices, 6);

  glm::mat4 proj = glm::ortho(0.0f, 1024.0f, 0.0f, 768.0f, -1.0f, 1.0f);
  glm::mat4 view =
      glm::translate(glm::mat4(1.0f), glm::vec3(0.0f, 0.0f, 0.0f));

  Shader shader("res/shaders/Basic.shader");
  shader.Bind();
  shader.SetUnifrom4f("u_Color", 0.8, 0.2, 0.2, 1.0);

  Texture texture("res/textures/log.png");
  texture.Bind(0);
  shader.SetUnifrom1i("u_Texture", 0);

  Renderer renderer;
  ImGui::CreateContext();
  ImGui_ImplGlfwGL3_Init(window, true);
  ImGui::StyleColorsDark();

  float r = 0.4;
  float g = 0.7;
  float b = 0.5;
  float increment = 0.3;

  glm::vec3 translateA(200.0f, 100.0f, 0.0f);
  glm::vec3 translateB(400.0f, 100.0f, 0.0f);

  while (!glfwWindowShouldClose(window)) {
    renderer.Clear();

    ImGui_ImplGlfwGL3_NewFrame();

    {
      glm::mat4 model = glm::translate(glm::mat4(1.0f), translateA);
      glm::mat4 mvp = proj * view * model;
      shader.SetUnifromMat4f("u_MVP", mvp);
      renderer.Draw(va, ib, shader);
    }

    {
      glm::mat4 model = glm::translate(glm::mat4(1.0f), translateB);
      glm::mat4 mvp = proj * view * model;
      shader.SetUnifromMat4f("u_MVP", mvp);
      renderer.Draw(va, ib, shader);
    }


    if (r >= 1.0) {
      r -= increment;
    } else if (r < 1.0) {
      r += increment;
    }

    if (g >= 1.0) {
      g -= increment;
    } else if (g < 1.0) {
      g += increment;
    }

    if (b >= 1.0) {
      b -= increment;
    } else if (b < 1.0) {
      b += increment;
    }

    {
      ImGui::SliderFloat3("Translation A", &translateA.x, 0.0f, 900.0f);
      ImGui::SliderFloat3("Translation B", &translateB.x, 0.0f, 900.0f);
      ImGui::Text("Application average %.3f ms/frame (%.1f FPS)",
                  1000.0f / ImGui::GetIO().Framerate, ImGui::GetIO().Framerate);
    }

    ImGui::Render();
    ImGui_ImplGlfwGL3_RenderDrawData(ImGui::GetDrawData());
    glfwSwapBuffers(window);

    glfwPollEvents();
  }
  ImGui_ImplGlfwGL3_Shutdown();
  ImGui::DestroyContext();
  glfwTerminate();

  return 0;
}