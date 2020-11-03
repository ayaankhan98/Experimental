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

int main() {
  if (!glfwInit()) {
    return -1;
  }

  GLFWwindow* window = glfwCreateWindow(1024, 720, "OpenGL", NULL, NULL);

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
      -0.5f, -0.5f, 0.0f, 0.0f,
       0.5f, -0.5f, 1.0f, 0.0f,
       0.5f,  0.5f, 1.0f, 1.0f,
      -0.5f,  0.5f, 0.0f, 1.0f
  };

  // Using Index buffer to keep GPU memory as low as possible, by prohibiting
  // ourself to no to copy same data again and again, just supply only unique
  // data points (Vertices)
  unsigned int indices[] = {0, 1, 2, 2, 3, 0};

  VertexArray va;
  VertexBuffer vb(positions, 4 * 4 * sizeof(float));
  VertexBufferLayout layout;
  layout.Push<float>(2);
  layout.Push<float>(2);
  va.AddBuffer(vb, layout);

  IndexBuffer ib(indices, 6);

  Shader shader("res/shaders/Basic.shader");
  shader.Bind();
  shader.SetUnifrom4f("u_Color", 0.8, 0.2, 0.2, 1.0);

  Texture texture("res/textures/logo.png");
  texture.Bind();
  shader.SetUnifrom1i("u_Texture", 0);

  Renderer renderer;

  float r = 0.4;
  float g = 0.7;
  float b = 0.5;
  float increment = 0.3;

  while (!glfwWindowShouldClose(window)) {
    renderer.Clear();

    shader.SetUnifrom4f("u_Color", r, g, b, 1.0);

    renderer.Draw(va, ib, shader);

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

    // glDrawArrays(GL_TRIANGLES, 0, 3);

    glfwSwapBuffers(window);

    glfwPollEvents();
  }

  return 0;
}